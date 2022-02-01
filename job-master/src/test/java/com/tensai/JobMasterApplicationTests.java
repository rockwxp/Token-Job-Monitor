package com.tensai;

import com.tensai.pojo.TaskInstance;
import com.tensai.service.TaskInstanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest(classes = JobMasterApplication.class)
class JobMasterApplicationTests {

	@Autowired
	private TaskInstanceService taskInstanceService;
	@Test
	void contextLoads() {
		TaskInstance taskInstance = new TaskInstance();
		String id = UUID.randomUUID().toString();
		taskInstance.setId(id);
		taskInstance.setType("token");
		taskInstance.setValue("OXY");
		taskInstance.setStatus(0);
		taskInstance.setTaskOwner("rock");
		taskInstance.setCreatedBy("rock");
		taskInstance.setUpdatedBy("rock");
		Integer result = taskInstanceService.insertTaskInstance(taskInstance);
		if(result>0){
			System.out.println("insert success");
		}

	}

}
