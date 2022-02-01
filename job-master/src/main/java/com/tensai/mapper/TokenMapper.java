package com.tensai.mapper;

import com.tensai.pojo.TaskInstance;
import com.tensai.pojo.Token;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Rock
 * @date 1/26/22 11:30 PM
 * @description TODO
 */
@Mapper
public interface TokenMapper {
    List<Token> findAll();

    Token getTaskToken();

    Integer updateTaskToken(Token taskToken);

    Token findByTokenName(String tokenName);
}
