package org.hitechr.garobo.common.utils;
/**
 * @Package org.hitechr.garobo.common.utils
 * @Title: DateUtils
 * @author hapic
 * @date 2018/5/2 15:13
 * @version V1.0
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Descriptions:
 */
public class DateUtils {

    public static long currentTimeMillis(){
        return System.currentTimeMillis();
    }

    public static String currentTime(){
        Date date = null;
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
