package com.rock.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rock.mapper.TaskInstanceMapper;
import com.rock.pojo.TaskInstance;
import com.rock.service.TaskInstanceService;
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
}
