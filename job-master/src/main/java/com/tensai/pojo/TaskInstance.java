package com.tensai.pojo;

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

    private String id;
    private String type;
    private String value;
    private Integer status;
    private String taskOwner;
    private String createdBy;
    private String updatedBy;
    private Long cratedTime;
    private Long updatedTime;


}
