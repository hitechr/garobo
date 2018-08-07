/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package org.hitechr.garobo.console.service;


import jdk.nashorn.internal.runtime.options.Option;
import org.hitechr.garobo.console.common.web.service.BaseService;
import org.hitechr.garobo.console.mapper.GroupMapper;
import org.hitechr.garobo.console.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hitechr.garobo.console.vo.GroupVo;
import org.hitechr.garobo.console.model.GroupExample;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService extends BaseService<Group, GroupExample> {

    @Autowired
    private GroupMapper groupMapper;

    /**
     * 按任务组名称查询记录
     * @param name
     * @return
     */
    public Optional<Group> findGroupByName(String name) {
        GroupExample groupExample= new GroupExample();
        groupExample.createCriteria()
                .andNameEqualTo(name);
        Group byExample = groupMapper.getByExample(groupExample);
        return Optional.ofNullable(byExample);
    }


    public Optional<Group> selectByPrimaryId(Object id){
        Group group = super.selectByPrimaryKey(id);
        return Optional.ofNullable(group);
    }
}
