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

import org.hitechr.garobo.console.model.JobDep;
import org.hitechr.garobo.console.model.JobDepExample;


@Repository
public interface JobDepMapper extends BaseMapper<JobDep, JobDepExample> {

    int saveDepRelation(@Param("groupId") Integer groupId, @Param("jobId") Integer jobId, @Param("depJobIds") Integer[] depJobIds);

    int updateJobLastValue(@Param("depJobIds")Integer[] depJobIds);

    int selectMaxFlowNum(Integer[] depJobIds);
}
