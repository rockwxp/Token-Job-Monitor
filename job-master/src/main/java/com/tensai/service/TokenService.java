package com.tensai.service;


import com.tensai.pojo.Token;

import java.util.List;

/**
 * @author Rock
 * @date 1/26/22 11:25 PM
 * @description TODO
 */
public interface TokenService {
    List<Token> findAll();

    String getTokenTask(String taskOwner);

    Integer endTokenTask(String tokenName, String taskOwner);
}
