package com.rock.service;

/**
 * @author Rock
 * @date 2022/5/3 16:55
 * @description TODO
 */
public interface KafkaConsumerService {
    void receive(String message);
}
