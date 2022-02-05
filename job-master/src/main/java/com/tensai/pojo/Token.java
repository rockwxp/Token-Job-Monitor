package com.tensai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author Rock
 * @date 2/1/22 3:18 PM
 * @description TODO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Token {
    private Integer id;
    private String name;
    private String lastTaskInstanceId;
    private Integer status;
    private String heartbeat;
    private Long lastHeartbeatTime;
    private String createdBy;
    private String updatedBy;
    private Long cratedTime;
    private Long updatedTime;
}
