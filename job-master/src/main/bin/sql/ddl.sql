drop table if exists t_task_instance;
CREATE TABLE if not exists `t_task_instance`
(
    `t_id`          char(100)            NOT NULL,
    `t_type`        char(100)          DEFAULT NULL,
    `t_value`       char(100)          DEFAULT NULL,
    `t_status`      int(11)            DEFAULT NULL,
    `t_task_owner`  char(100)          DEFAULT NULL,
    `t_created_by`  char(100)          DEFAULT NULL,
    `t_updated_by`  char(100)          DEFAULT NULL,
    `t_crated_time`                    timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `t_updated_time`                   timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`t_id`)
);
drop table if exists t_task_token;
CREATE TABLE if not exists `t_task_token`
(
    `t_id`                    int(11) NOT NULL AUTO_INCREMENT,
    `t_name`                  char(100) DEFAULT NULL,
    `t_last_task_instance_id` char(100) DEFAULT NULL,
    `t_status`                int(11) DEFAULT NULL,
    `t_created_by`            char(100)  DEFAULT NULL,
    `t_updated_by`            char(100) DEFAULT NULL,
    `t_crated_time`           timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `t_updated_time`          timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`t_id`)
);
