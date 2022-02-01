package com.tensai.service.impl;


import com.tensai.mapper.TaskInstanceMapper;
import com.tensai.pojo.TaskInstance;
import com.tensai.pojo.Token;
import com.tensai.service.TaskInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author Rock
 * @date 1/26/22 11:26 PM
 * @description TODO
 */
@Service
@Transactional
public class TaskInstanceServiceImpl implements TaskInstanceService {

    @Autowired
    private TaskInstanceMapper taskInstanceMapper;
    @Override
    public List<TaskInstance> findAll() {
        //PageHelper.startPage(2,1);
        List<TaskInstance> list = taskInstanceMapper.findAll();
        //PageInfo<TaskInstance> taskInstancePageInfo = new PageInfo<>(list);
        return list;
    }

    @Override
    public Integer insertTaskInstance(TaskInstance taskInstance) {

        Integer result = taskInstanceMapper.addTaskInstance(taskInstance);
        return result;
    }

    @Override
    public TaskInstance addTaskInstance(Token taskToken,String taskOwner) {
        TaskInstance taskInstance = new TaskInstance();
        UUID uuid = UUID.randomUUID();
        String taskInstanceId = uuid.toString();
        taskInstance.setId(taskInstanceId);
        taskInstance.setType("token");
        taskInstance.setValue(taskToken.getName());
        taskInstance.setStatus(1);
        taskInstance.setTaskOwner(taskOwner);
        taskInstance.setCreatedBy(taskOwner);
        taskInstance.setUpdatedBy(taskOwner);
        Integer result = taskInstanceMapper.addTaskInstance(taskInstance);
        return taskInstance;
    }

    @Override
    public Integer updateTaskInstance(TaskInstance taskInstance) {

        return taskInstanceMapper.updateTaskInstance(taskInstance);
    }

}
