package com.tensai;

import com.tensai.pojo.TaskInstance;
import com.tensai.service.TaskInstanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@Test
	void test_tiem(){

		System.out.println(Instant.now());
		Instant instant = Instant.now();
		Timestamp timestamp = Timestamp.from(instant);
		Date date = Date.from(instant);
		System.out.println(timestamp);
		System.out.println(date);
		long unixTimestamp = Instant.now().getEpochSecond();
		System.out.println(unixTimestamp);
		System.out.println(System.currentTimeMillis());


		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp1);
		Date date1 = new Date(1644048953000l);
		System.out.println(date1);

		long epoch = System.currentTimeMillis()/1000;
		System.out.println(epoch);
	}

}

