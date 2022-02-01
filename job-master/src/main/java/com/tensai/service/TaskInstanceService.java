package com.tensai.service;



import com.tensai.pojo.TaskInstance;
import com.tensai.pojo.Token;

import java.util.List;

/**
 * @author Rock
 * @date 1/26/22 11:25 PM
 * @description TODO
 */
public interface TaskInstanceService {
    List<TaskInstance> findAll();

    Integer insertTaskInstance(TaskInstance taskInstance);

    TaskInstance addTaskInstance(Token taskToken,String taskOwner);

    Integer updateTaskInstance(TaskInstance taskInstance);
}
