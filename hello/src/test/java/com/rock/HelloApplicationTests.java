package com.rock;

import com.rock.pojo.TaskInstance;
import com.rock.service.TaskInstanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = HelloApplication.class)
class HelloApplicationTests {

    @Autowired
    private TaskInstanceService taskInstanceService;

    @Autowired
    private String config_test2;

    @Test
    void test() {
        List<TaskInstance> all = taskInstanceService.findAll();
        all.forEach(System.out::println);
        System.out.println(config_test2);
    }

}
