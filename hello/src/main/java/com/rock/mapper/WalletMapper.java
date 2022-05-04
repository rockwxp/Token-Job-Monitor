package com.rock.mapper;

import com.rock.pojo.Wallet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Rock
 * @date 1/26/22 11:30 PM
 * @description TODO
 */
@Mapper
public interface WalletMapper {
    List<Wallet> getWalletAddress();
}
