package com.rock.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rock
 * @date 4/16/22 9:50 PM
 * @description TODO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Wallet {
    private String address;
    private String signature;
}
