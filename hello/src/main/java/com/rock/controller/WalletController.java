package com.rock.controller;



import com.rock.pojo.Wallet;
import com.rock.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Rock
 * @date 1/26/22 11:21 PM
 * @description TODO
 */
@Controller
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    //http://localhost:8089/hello/wallet/getWalletSignature
    @RequestMapping("getWalletSignature")
    @ResponseBody
    public List<Wallet> getWalletSignature(){

        return walletService.getWalletSignature();
    }
}
