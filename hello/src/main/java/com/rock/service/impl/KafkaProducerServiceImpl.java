package com.rock.service.impl;

import com.rock.service.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Rock
 * @date 2022/5/3 16:41
 * @description TODO
 */
@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {


    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void send(String topic,String message) {
        kafkaTemplate.send(topic, message);
        logger.info("message sent: {}", message);
    }
}
