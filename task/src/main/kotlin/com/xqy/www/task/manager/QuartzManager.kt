package com.xqy.www.task.manager

import com.xqy.www.task.job.ScheduledTask
import org.quartz.*
import org.quartz.impl.StdSchedulerFactory
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class QuartzManager{
    private lateinit var triggerMap:HashMap<String,Trigger>
    private lateinit var jobDetailMap:HashMap<String,JobDetail>
    private lateinit var schedulerFactory: StdSchedulerFactory
    @PostConstruct
    fun init(){
        triggerMap = hashMapOf()
        jobDetailMap = hashMapOf()
        schedulerFactory = StdSchedulerFactory()
    }
    private fun initJobDetail(name:String){
        val jobDetail = JobBuilder.newJob(ScheduledTask::class.java).withIdentity(name).build()
        jobDetailMap[name] = jobDetail
    }
    private fun initSimpleTrigger(name:String,simpleScheduleType:(simpleScheduleBuilder:SimpleScheduleBuilder)->SimpleScheduleBuilder ){
        val trigger = TriggerBuilder.newTrigger().withIdentity(name)
                .withSchedule(simpleScheduleType(SimpleScheduleBuilder.simpleSchedule()))
                .build()
        triggerMap[name] = trigger

    }

    fun executeJob(name: String,simpleScheduleType:(simpleScheduleBuilder:SimpleScheduleBuilder)->SimpleScheduleBuilder){
        val jobDetail = jobDetailMap[name]
        if (jobDetail == null){
            initJobDetail(name)
        }
        val trigger = triggerMap[name]
        if (trigger == null){
            initSimpleTrigger(name,simpleScheduleType)
        }
        val scheduler = schedulerFactory.scheduler
        val isStarted = scheduler.isStarted
        if (!isStarted){
            scheduler.start()
        }
        scheduler.scheduleJob(jobDetailMap[name],triggerMap[name])

    }

}