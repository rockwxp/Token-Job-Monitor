package com.tensai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Rock
 * @date 1/25/22 10:53 PM
 * @description TODO
 */
@Controller
public class MyController {
    @ResponseBody
    @RequestMapping("/testController")
    public String testController(){
        return "hello rock";
    }
}
