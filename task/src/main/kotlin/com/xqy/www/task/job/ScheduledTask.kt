package com.xqy.www.task.job

import com.xqy.www.commom.utils.printMessage
import com.xqy.www.task.constant.TASK_SERVICE_NAME
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
        ScheduledTask.applicationContext = applicationContext
    }

    override fun execute(context: JobExecutionContext?) {
        try {
            val name = context!!.mergedJobDataMap.getString(TASK_SERVICE_NAME)
            ScheduledTask.applicationContext.getBean(name,ScheduledTaskService::class.java).executeTask(name)

        }catch (e:Exception){
            printMessage("无该任务服务")

        }

    }


}