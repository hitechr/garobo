package org.hitechr.garobo.console.scheduler;
/**
 * @Package org.hitechr.garobo.console.scheduler
 * @Title: SchedulerManager
 * @author hitechr
 * @date 2018/8/3 15:34
 * @version V1.0
 */

import org.hitechr.garobo.console.vo.JobVo;
import org.quartz.*;

/**
 * @Descriptions: job管理，包括添加，暂停，删除
 * @from  https://blog.csdn.net/fantasic_van/article/details/74942062
 */
public class SchedulerManager {

    private Scheduler scheduler;

    public SchedulerManager(Scheduler scheduler) {
        this.scheduler = scheduler;
    }


    /**
     * 添加一个任务到内存中
     * @param jobBean
     */
    public void addJob(JobBean jobBean){
        addJob(jobBean.getJobName(),jobBean.getJobGroup(),jobBean.getTriggerName(),jobBean.getTriggerGroup(),jobBean.getCron());
    }

    /**
     * 更新任务的执行时间
     * @param jobBean
     */
    public void modifyJobTime(JobBean jobBean){
        modifyJobTime(jobBean.getTriggerName(),jobBean.getTriggerGroup(),jobBean.getCron());
    }

    /**
     * 从内存中移除一个任务
     * @param jobBean
     */
    public void removeJob(JobBean jobBean){
        removeJob(jobBean.getJobName(),jobBean.getJobGroup(),jobBean.getTriggerName(),jobBean.getTriggerGroup());
    }

    /**
     * 暂停一个任务
     * @param jobBean
     */
    public void pauseJob(JobBean jobBean){
        try {
            JobKey jobKey = JobKey.jobKey(jobBean.getJobName(), jobBean.getJobGroup());
            if(scheduler.checkExists(jobKey)){
                scheduler.pauseJob(jobKey);

            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 任务的恢复
     * @param jobBean
     */
    public void resumeJob(JobBean jobBean){
        try {
            JobKey jobKey = JobKey.jobKey(jobBean.getJobName(), jobBean.getJobGroup());
            if(scheduler.checkExists(jobKey)){
                scheduler.resumeJob(jobKey);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }





    //基础方法==============================================================================

    private void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
                       String cron){
        addJob(jobName,jobGroupName,triggerName,triggerGroupName,ExecuteJob.class,cron);

    }

    /**
     * @Description: 添加一个定时任务
     *
     * @param jobName
     *            任务名
     * @param jobGroupName
     *            任务组名
     * @param triggerName
     *            触发器名
     * @param triggerGroupName
     *            触发器组名
     * @param jobClass
     *            任务
     * @param cron
     *            时间设置，参考quartz说明文档
     */
    private void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass,
                       String cron) {
        try {

            // 任务名，任务组，任务执行类
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();

            // 触发器
            TriggerBuilder<Trigger> triggerBuilder =   TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            //立即触发任务
            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();

            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, trigger);

            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: 修改一个任务的触发时间
     *
     * @param triggerName
     *            触发器名
     * @param triggerGroupName
     *            触发器组名
     * @param cron
     *            时间设置，参考quartz说明文档
     */
    private void modifyJobTime(String triggerName, String triggerGroupName,
                              String cron) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }

            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cron)) {
                /** 方式一 ：调用 rescheduleJob 开始 */
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(triggerName, triggerGroupName);
                triggerBuilder.startNow();
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
                // 创建Trigger对象
                trigger = (CronTrigger) triggerBuilder.build();
                // 方式一 ：修改一个任务的触发时间
                scheduler.rescheduleJob(triggerKey, trigger);
                /** 方式一 ：调用 rescheduleJob 结束 */

                /** 方式二：先删除，然后在创建一个新的Job */
                // JobDetail jobDetail =
                // scheduler.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
                // Class<? extends Job> jobClass = jobDetail.getJobClass();
                // removeJob(jobName, jobGroupName, triggerName,
                // triggerGroupName);
                // addJob(jobName, jobGroupName, triggerName, triggerGroupName,
                // jobClass, cron);
                /** 方式二 ：先删除，然后在创建一个新的Job */
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: 移除一个任务
     *
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     */
    private void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);

            scheduler.pauseTrigger(triggerKey);// 停止触发器
            scheduler.unscheduleJob(triggerKey);// 移除触发器
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:启动所有定时任务
     */
    private void startJobs() {
        try {
            scheduler.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:关闭所有定时任务
     */
    private void shutdownJobs() {
        try {
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
