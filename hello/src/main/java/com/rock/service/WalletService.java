package com.rock.service;

import com.rock.pojo.Wallet;

import java.util.List;

/**
 * @author Rock
 * @date 1/26/22 11:25 PM
 * @description TODO
 */
public interface WalletService {
    List<Wallet> getWalletSignature();

    List<Wallet> getWalletAddress();



}

