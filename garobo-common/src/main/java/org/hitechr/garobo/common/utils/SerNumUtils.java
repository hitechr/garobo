package org.hitechr.garobo.common.utils;
/**
 * @Package org.hitechr.garobo.common.utils
 * @Title: SerNumUtils
 * @author hapic
 * @date 2018/5/3 18:43
 * @version V1.0
 */

import java.util.UUID;

/**
 * @Descriptions:
 */
public class SerNumUtils {


    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
