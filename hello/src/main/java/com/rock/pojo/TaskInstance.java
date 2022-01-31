package com.rock.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;



/**
 * @author Rock
 * @date 1/26/22 9:56 PM
 * @description TODO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskInstance {

    private Integer id;
    private String type;
    private String value;
    private String taskOwner;
    private Timestamp cratedTime;


}
