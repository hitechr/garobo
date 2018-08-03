package org.hitechr.garobo.zk;
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



     private static String AGENT_PATH  ="/executer/%s";//agent的注册地址
     private static String AGENT_STATUS=AGENT_PATH+"/status";//agent 状态
     private static String AGET_JOBS=AGENT_PATH+"/jobs";//添加到这个机器运行的任务

     private static String JOB_PATH="/jobs/%s";//job的路径
     private static String JOB_CRON=JOB_PATH+"/cron";//job的cron表达式路径
     private static String JOB_EXECUTE=JOB_PATH+"/execute";//job的执行ip
     private static String JOB_STATUS=JOB_PATH+"/status";//job状态
     private static String JOB_CHILDS=JOB_PATH+"/childs";//后置任务
     private static String JOB_DEPENDENT=JOB_PATH+"/dependent";//前置任务


     private static String EXECUTION_JOB_PATH="/execution/%s/%s";//当前job的运行路径
     private static String EXECUTION_JOB_STATUS=EXECUTION_JOB_PATH+"/status";//当前执行job的运行路径
     private static String EXECUTION_JOB_EXECUTE=EXECUTION_JOB_PATH+"/execute";//当前执行job 的客户端
     private static String EXECUTION_JOB_RESULT=EXECUTION_JOB_PATH+"/result";//当前执行job 结果
     private static String EXECUTION_JOB_DEPENDENT=EXECUTION_JOB_PATH+"/dependent";//当前执行job 依赖job已经完成的


     public static String RESULT_PATH="/result/s%/s%"; //保存运行结果的路径


     public static String PENDING_JOB_PATH="/pending/s%/s%";//待执行的
     public static String PENDING_JOB_NAME=PENDING_JOB_PATH+"/s%";//待执行的任务名称


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
      * 获取job的执行ip
      * @param jobId
      * @return
      */
     public static String getJobExecute(String jobId){
          return format(JOB_EXECUTE,jobId);
     }


     public static String getExecutionJobPath(String runId,String jobId){
          return format(EXECUTION_JOB_PATH,jobId,runId);
     }

     public static String getExecutionJobStatus(String jobId,String runId){
          return format(EXECUTION_JOB_STATUS,jobId,runId);
     }

     /**
      * 获取job的时间表达式
      * @param jobId
      * @return
      */
     public static String getJobCronPath(String jobId){
          return format(JOB_CRON,jobId);
     }


     private static String format(String format,String... value){
          return String.format(format,value);
     }


     public static String getResultPath(String runid,String jobId){
          return format(RESULT_PATH,runid,jobId);
     }

     public static String getJobChilds(String jobId){
          return format(JOB_CHILDS,jobId);
     }

     public static String getExecutionJobDependent(String runnid,String jobId){
          return format(EXECUTION_JOB_DEPENDENT,jobId,runnid);
     }


     public static String getJobDependent(String jobId){
          return format(JOB_DEPENDENT,jobId);
     }

     public static String getPendingJobPath(String ip,String runid){
          return format(PENDING_JOB_PATH,ip,runid);
     }

     public static String getPendingJobName(String ip,String runid,String jobName){
          return format(PENDING_JOB_NAME,ip,runid,jobName);
     }


}
