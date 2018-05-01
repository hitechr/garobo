/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


package org.hitechr.garobo.console.mapper;


import org.hitechr.garobo.console.common.web.dao.BaseMapper;
import org.springframework.stereotype.Repository;

import org.hitechr.garobo.console.model.JobRecord;
import org.hitechr.garobo.console.model.JobRecordExample;


@Repository
public interface JobRecordMapper extends BaseMapper<JobRecord, JobRecordExample> {
	
}
