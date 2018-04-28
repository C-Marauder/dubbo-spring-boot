package com.xqy.www.task.manager

import com.xqy.www.task.dao.TaskInformation
import com.xqy.www.task.job.ScheduledTask
import org.quartz.*
import org.quartz.impl.StdSchedulerFactory
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class QuartzManager {
    private lateinit var taskInfoMap: HashMap<String, TaskInformation>
    private lateinit var scheduler: Scheduler
    @PostConstruct
    fun init() {
        taskInfoMap = hashMapOf()
        scheduler = StdSchedulerFactory().scheduler
    }

    private fun initJobDetail(name: String, jobDataMap: (jobDataMap: JobDataMap) -> JobDataMap): Pair<JobKey, JobDetail> {
        val jobKey = JobKey(name)
        val jobDetail = JobBuilder.newJob(ScheduledTask::class.java)
                .withIdentity(jobKey)
                .setJobData(jobDataMap(JobDataMap()))
                .build()
        return Pair(jobKey, jobDetail)
    }

    private fun initSimpleTrigger(name: String, simpleScheduleType: (simpleScheduleBuilder: SimpleScheduleBuilder) -> SimpleScheduleBuilder): Pair<TriggerKey, SimpleTrigger> {
        val triggerKey = TriggerKey(name)
        val trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
                .startNow()
                .withSchedule(simpleScheduleType(SimpleScheduleBuilder.simpleSchedule()))
                .build()
        return Pair(triggerKey, trigger)
    }

    fun executeJob(name: String, jobDataMap: (jobDataMap: JobDataMap) -> JobDataMap, simpleScheduleType: (simpleScheduleBuilder: SimpleScheduleBuilder) -> SimpleScheduleBuilder) {
        val taskInfo = taskInfoMap[name]
        if (taskInfo == null) {
            val jobDetailPair = initJobDetail(name, jobDataMap)
            val triggerPair = initSimpleTrigger(name, simpleScheduleType)
            taskInfoMap[name] = TaskInformation(jobDetailPair.first, jobDetailPair.second, triggerPair.first, triggerPair.second, false)
            scheduler.scheduleJob(jobDetailPair.second, triggerPair.second)

        } else {
            val isPaused = taskInfo.isPaused
            if (isPaused) {
                scheduler.resumeJob(taskInfo.jobKey)
                scheduler.resumeTrigger(taskInfo.triggerKey)
            }
        }

        val isStarted = scheduler.isStarted
        if (!isStarted) {
            scheduler.start()
        }

    }

    fun pauseJob(name: String) {
        val taskInfo = taskInfoMap[name]
        if (taskInfo != null && !taskInfo.isPaused) {
            taskInfo.isPaused = true
            scheduler.pauseJob(taskInfo.jobKey)
            scheduler.pauseTrigger(taskInfo.triggerKey)
        }
    }

    fun resumeJob(name: String) {
        val taskInfo = taskInfoMap[name]
        if (taskInfo != null && taskInfo.isPaused) {
            taskInfo.isPaused = false
            scheduler.resumeJob(taskInfo.jobKey)
            scheduler.resumeTrigger(taskInfo.triggerKey)
        }
    }
}