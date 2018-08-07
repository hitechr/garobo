package org.hitechr.garobo.console.serviceTest;
/**
 * @Package org.hitechr.garobo.console.serviceTest
 * @Title: GroupServiceTest
 * @author hitechr
 * @date 2018/8/6 17:23
 * @version V1.0
 */

import org.hitechr.garobo.console.model.Group;
import org.hitechr.garobo.console.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.Optional;

/**
 * @Descriptions:
 */
public class GroupServiceTest extends BaseTest {


    @Autowired
    private GroupService groupService;

    @Test
    public void testFindGroupByName(){
        Optional<Group> test = groupService.findGroupByName("测试111111");
        if(test.isPresent()){
            System.out.println(test);
        }

    }
}
