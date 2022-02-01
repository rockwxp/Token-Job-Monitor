package com.tensai.controller;



import com.tensai.pojo.TaskInstance;
import com.tensai.service.TaskInstanceService;
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
@RequestMapping("/taskInstance")
public class TaskInstanceController {

    @Autowired
    private TaskInstanceService taskInstanceService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<TaskInstance> findAll(){

        return taskInstanceService.findAll();
    }



}
