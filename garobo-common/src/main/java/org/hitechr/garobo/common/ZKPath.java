package org.hitechr.garobo.common;
/**
 * @Package org.hitechr.garobo.common
 * @Title: ZKPath
 * @author hapic
 * @date 2018/5/2 15:21
 * @version V1.0
 */

/**
 * @Descriptions:
 */
public class ZKPath {



     private static String AGENT_PATH  ="/agent/%s";//agent的注册地址
     private static String AGENT_STATUS=AGENT_PATH+"/status";//agent 状态
     private static String AGET_JOBS=AGENT_PATH+"/jobs";//添加到这个机器运行的任务

     /**
      * agent节点
      * @param ip
      * @return
      */
     public static String getAgentPath(String ip){
          return String.format(AGENT_PATH,ip);
     }

     /**
      * 当前agent下的status节点
      * @param ip
      * @return
      */
     public static String getAgentStatusPath(String ip){
          return String.format(AGENT_STATUS,ip);
     }

     /**
      * 当前agent下的任务节点
      * @param ip
      * @return
      */
     public static String getAgentJobsPath(String ip){
          return String.format(AGET_JOBS,ip);
     }





}
