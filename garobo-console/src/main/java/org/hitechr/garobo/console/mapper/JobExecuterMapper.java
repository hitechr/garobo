/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


package org.hitechr.garobo.console.mapper;


import org.apache.ibatis.annotations.Param;
import org.hitechr.garobo.console.common.web.dao.BaseMapper;
import org.springframework.stereotype.Repository;

import org.hitechr.garobo.console.model.JobExecuter;
import org.hitechr.garobo.console.model.JobExecuterExample;


@Repository
public interface JobExecuterMapper extends BaseMapper<JobExecuter, JobExecuterExample> {


    int saveRelation(@Param("jobId") int jobId, @Param("groupId")int groupId, @Param("execIds")Integer[] execIds);
}
