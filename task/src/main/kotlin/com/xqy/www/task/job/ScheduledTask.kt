package com.xqy.www.task.job

import com.xqy.www.commom.utils.printMessage
import com.xqy.www.task.service.ScheduledTaskService
import org.quartz.Job
import org.quartz.JobExecutionContext
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.*

/**
 *
 */
@Component
class  ScheduledTask :Job, ApplicationContextAware {
    companion object {
        private lateinit var applicationContext: ApplicationContext

    }
    override fun setApplicationContext(applicationContext: ApplicationContext) {
        printMessage("初始化完成")
        ScheduledTask.applicationContext = applicationContext
    }

    override fun execute(context: JobExecutionContext?) {
        val name = context!!.mergedJobDataMap.getString("name")
        ScheduledTask.applicationContext.getBean(name,ScheduledTaskService::class.java).executeTask(name)
//        printMessage("${Date()}")
    }

//    @Scheduled(fixedDelay = 1000)
//    fun executeTask(){
//        printMessage("执行任务: ${Date()}")
//    }
}