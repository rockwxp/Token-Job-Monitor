package com.tensai.service.impl;


import com.tensai.mapper.TaskInstanceMapper;
import com.tensai.mapper.TokenMapper;
import com.tensai.pojo.TaskInstance;
import com.tensai.pojo.Token;
import com.tensai.service.TaskInstanceService;
import com.tensai.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 * @author Rock
 * @date 1/26/22 11:26 PM
 * @description TODO
 */
@Service
@Transactional
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private TaskInstanceService taskInstanceService;


    @Override
    public List<Token> findAll() {
        //PageHelper.startPage(2,1);
        List<Token> list = tokenMapper.findAll();
        //PageInfo<TaskInstance> taskInstancePageInfo = new PageInfo<>(list);
        return list;
    }


    @Override
    public String getTokenTask(String taskOwner) {
        String tokenName = null;
        Token taskToken = tokenMapper.getTaskToken();
        if (taskToken != null) {
            TaskInstance taskInstance = taskInstanceService.addTaskInstance(taskToken, taskOwner);
            String taskInstanceId = taskInstance.getId();
            taskToken.setLastTaskInstanceId(taskInstanceId);
            taskToken.setStatus(1);
            taskToken.setHeartbeat("running");
            taskToken.setUpdatedTime(System.currentTimeMillis() / 1000);
            taskToken.setUpdatedBy(taskOwner);
            Integer result = tokenMapper.updateTaskToken(taskToken);
            tokenName = taskToken.getName();
        }

        return tokenName;
    }

    @Override
    public Integer endTokenTask(String tokenName, String taskOwner, Integer status) {
        Token taskToken = tokenMapper.findByTokenName(tokenName);
        if (taskToken != null) {
            String lastTaskInstanceId = taskToken.getLastTaskInstanceId();
            taskToken.setStatus(status);
            taskToken.setUpdatedTime(System.currentTimeMillis() / 1000);
            taskToken.setUpdatedBy(taskOwner);
            Integer result1 = tokenMapper.updateTaskToken(taskToken);
            TaskInstance taskInstance = new TaskInstance();
            taskInstance.setId(lastTaskInstanceId);
            taskInstance.setStatus(status);
            taskInstance.setUpdatedTime(System.currentTimeMillis() / 1000);
            taskInstance.setUpdatedBy(taskOwner);
            Integer result2 = taskInstanceService.updateTaskInstance(taskInstance);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Integer sendHeartbeat(String tokenName, String heartbeat, String taskOwner) {
        Token token = new Token();
        token.setName(tokenName);
        token.setHeartbeat(heartbeat);
        token.setLastHeartbeatTime(System.currentTimeMillis() / 1000);
        token.setUpdatedBy(taskOwner);
        return tokenMapper.updateTokenHeartbeat(token);
    }

    @Scheduled(cron = "0 0/5 * * * *")
    public void monitor() {
        Integer result = tokenMapper.monitorHeartbeat();
    }
}
