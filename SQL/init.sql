CREATE DATABASE `garobo`;
USE garobo;

DROP TABLE IF EXISTS `g_job`;
CREATE TABLE `g_job` (
  `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` VARCHAR(32) NOT NULL COMMENT '任务的名称',
  `type` INT(10) NOT NULL COMMENT '作业类型(quartz\cron\python)',
  `last` BIT(2) NOT NULL COMMENT '是否是最后一个',
  `status` TINYINT(2) NOT NULL COMMENT '任务的状态',
  `job_cron` VARCHAR(32) DEFAULT NULL COMMENT '时间表达式',
  `command` TEXT COMMENT '执行的命令',
  `jobDesc` VARCHAR(256) DEFAULT NULL COMMENT '作业描述',
  `flow_num` INT(10) NOT NULL COMMENT '层级',
  `group_id` INT(10) NOT NULL COMMENT '所在组Id',
  `success_code` INT(10) NOT NULL COMMENT '成功码',
  `weight` TINYINT(3) NOT NULL COMMENT '任务权重',
  `redo` INT(10) NOT NULL COMMENT '重试次数',
  `redo_now` INT(2) NOT NULL COMMENT '是否立即重试',
  `alarmCode` int(10) DEFAULT NULL COMMENT '通知码',
  `time_out` int(10) DEFAULT NULL COMMENT '超时时间',
  `insert_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `udate_date` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `GROUPID` (`group_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `g_group`;
CREATE TABLE `g_group` (
  `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` VARCHAR(32) NOT NULL COMMENT '组名称名称',
  `comment` VARCHAR(256) DEFAULT NULL COMMENT '组描述',
  `version` INT(10) DEFAULT 0 COMMENT '版本号',
  `insert_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `udate_date` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `g_job_dep`;
CREATE TABLE `g_job_dep` (
  `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `depjob_id` INT(10) NOT NULL COMMENT '依赖任务ID',
  `jobId` INT(10) NOT NULL COMMENT '当前任务ID',
  `group_id` INT(10) NOT NULL COMMENT '组ID',
  `status` TINYINT(2) NOT NULL COMMENT '依赖状态',
  `insert_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `udate_date` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `g_job_record`;
CREATE TABLE `g_job_record` (
  `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `job_name` VARCHAR(32) NULL COMMENT '执行任务名称',
  `runId` INT(10) null COMMENT '组行动ID',
  `group_id` INT(10) null COMMENT '组ID',
  `pid` INT(10) null COMMENT '服务器执行id',
  `serial_num` INT(10) null COMMENT '执行唯一编码',
  `jobId` INT(10) NOT NULL COMMENT '任务ID',
  `flow_num` INT(10) NOT NULL COMMENT '任务层级',
  `status` TINYINT(2) NOT NULL COMMENT '执行状态',
  `exec_id` INT(10) NOT NULL COMMENT '执行器ID',
  `command` TEXT COMMENT '执行的命令',
  `returnCode` INT(10) COMMENT '返回码',
  `message` VARCHAR(512) COMMENT '返回结果',
  `parentId` INT(10) null COMMENT '错误记录ID号',
  `redo_count` INT(10) COMMENT '第几次重试',
  `trigger` TINYINT(2) NOT NULL COMMENT '是否触发下级',
  `execType` TINYINT(2) DEFAULT 0 COMMENT '执行方式',
  `execUser` TINYINT(2) DEFAULT 0 COMMENT '执行人',
  `weight` TINYINT(3) NOT NULL COMMENT '任务权重',
  `version` INT(10) DEFAULT 0 COMMENT '版本号',
  `start_date` TIMESTAMP NULL COMMENT '开始时间',
  `end_date` TIMESTAMP NULL COMMENT '结束时间',
  `insert_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `udate_date` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `g_executer`;
CREATE TABLE `g_executer` (
  `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip` VARCHAR(32) NOT NULL COMMENT '执行器IP',
  `status` TINYINT(2) null COMMENT '执行器状态',
  `rid` VARCHAR(32) NOT NULL COMMENT '执行器运行ID',
  `insert_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `udate_date` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `g_job_executer`;
CREATE TABLE `g_job_executer` (
  `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `exec_id` INT(10) NOT NULL COMMENT '执行器ID',
  `job_id` TINYINT(2) null COMMENT '作业ID',
  `group_id` INT(10) null COMMENT '组ID',
  `status` TINYINT(2) null COMMENT '执行器状态',
  `insert_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `udate_date` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
