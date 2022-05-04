package com.rock.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.rock.common.HttpUtils;
import com.rock.mapper.WalletMapper;
import com.rock.pojo.Wallet;
import com.rock.service.KafkaProducerService;
import com.rock.service.WalletService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Rock
 * @date 1/26/22 11:26 PM
 * @description TODO
 */
@Service
@Transactional
public class WalletServiceImpl implements WalletService {



    @Autowired
    private KafkaProducerService kafkaProducerService;
    @Autowired
    private WalletMapper walletMapper;
    @SneakyThrows
    @Override
    public List<Wallet> getWalletSignature() {
        List<Wallet> wallets = getWalletAddress();
        for (int i = 0; i < wallets.size(); i++) {
            Wallet wallet = wallets.get(i);
            String address = wallet.getAddress();
            //String address = "2AQdpHJ2JpcEgPiATUXjQxA8QmafFegfQwSLWSprPicm";
            String requestBody="{\"jsonrpc\": \"2.0\",\"id\": 1,\"method\": \"getConfirmedSignaturesForAddress2\",\"params\": [\""+address+"\",{\"limit\": 1}]}";
            String response = HttpUtils.postHttpClient(requestBody);
            //System.out.println(response);
            JSONArray result = JSON.parseObject(response).getJSONArray("result");
            String signature = result.getJSONObject(0).get("signature").toString();
            wallet.setSignature(signature);
            String message = wallet.toString();
            kafkaProducerService.send("test",message);
            //System.out.println(wallet);
           // Thread.sleep(600);
        }
        return wallets;
    }

    @Override
    public List<Wallet> getWalletAddress() {
        List<Wallet> wallets = walletMapper.getWalletAddress();
        return wallets;
    }
}
