package com.rock.service;

/**
 * @author Rock
 * @date 2022/5/3 16:41
 * @description TODO
 */
public interface KafkaProducerService {
    void send(String topic,String message);
}
