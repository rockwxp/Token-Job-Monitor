package com.rock.controller;



import com.rock.pojo.Wallet;
import com.rock.service.KafkaConsumerService;
import com.rock.service.KafkaProducerService;
import com.rock.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author Rock
 * @date 1/26/22 11:21 PM
 * @description TODO
 */
@Controller
@RequestMapping("/kafka")
public class KafkatController {

    @Autowired
    private KafkaProducerService kafkaProducerService;
    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    //http://localhost:8089/hello/kafka/kafkaProducerTest
    @RequestMapping("kafkaProducerTest")
    @ResponseBody
    public String kafkaProducerTest(){

        Date date = new Date();
        String timeStr = date.toString();
        kafkaProducerService.send("test","test_"+timeStr);
        return timeStr;
    }
}
