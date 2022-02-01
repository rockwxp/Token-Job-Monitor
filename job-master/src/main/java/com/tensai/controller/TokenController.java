package com.tensai.controller;



import com.tensai.pojo.TaskInstance;
import com.tensai.pojo.Token;
import com.tensai.service.TaskInstanceService;
import com.tensai.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Rock
 * @date 1/26/22 11:21 PM
 * @description TODO
 */
@Controller
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private TaskInstanceService taskInstanceService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<Token> findAll(){

        return tokenService.findAll();
    }

    //http://localhost:8081/job-master/token/getTokenTask?taskOwner=rock
    //https://decent-destiny-329402.uc.r.appspot.com/job-master/token/getTokenTask?taskOwner=rock
    @RequestMapping("getTokenTask")
    @ResponseBody
    public String getTokenTask(@RequestParam String taskOwner){
        return tokenService.getTokenTask(taskOwner);
    }

    //http://localhost:8081/job-master/token/endTokenTask?tokenName=FIDA&taskOwner=rock1
    //https://decent-destiny-329402.uc.r.appspot.com/job-master/token/endTokenTask?tokenName=HXRO&taskOwner=rock1
    @RequestMapping("endTokenTask")
    @ResponseBody
    public Integer endTokenTask(@RequestParam String tokenName,@RequestParam String taskOwner){
        return tokenService.endTokenTask(tokenName,taskOwner);
    }

}
