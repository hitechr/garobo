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

     private static String JOB_PATH="/jobs/%s";//job的路径
     private static String JOB_CRON=JOB_PATH+"/cron";//job的cron表达式路径
     private static String JOB_STATUS=JOB_PATH+"/status";//job状态
     private static String JOB_CHILDS=JOB_PATH+"/childs";//后置任务
     private static String JOB_DEPENDENT=JOB_PATH+"/dependent";//前置任务

     /**
      * agent节点
      * @param ip
      * @return
      */
     public static String getAgentPath(String ip){
          return format(AGENT_PATH,ip);
     }

     /**
      * 当前agent下的status节点
      * @param ip
      * @return
      */
     public static String getAgentStatusPath(String ip){
          return format(AGENT_STATUS,ip);
     }

     /**
      * 当前agent下的任务节点
      * @param ip
      * @return
      */
     public static String getAgentJobsPath(String ip){
          return format(AGET_JOBS,ip);
     }

     /**
      * 获取一个job的路径
      * @param jobId
      * @return
      */
     public static String getJobPath(String jobId){
          return format(JOB_PATH,jobId);
     }

     /**
      * 获取job的时间表达式
      * @param jobId
      * @return
      */
     public static String getJobCronPath(String jobId){
          return format(JOB_CRON,jobId);
     }


     private static String format(String format,String value){
          return String.format(format,value);
     }




}
