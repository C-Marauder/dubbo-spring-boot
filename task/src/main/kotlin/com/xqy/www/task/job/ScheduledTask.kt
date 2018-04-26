package com.xqy.www.task.job

import com.xqy.www.commom.utils.printMessage
import org.quartz.Job
import org.quartz.JobExecutionContext
import java.util.*

class ScheduledTask :Job{

    override fun execute(context: JobExecutionContext?) {
        printMessage("${Date()}")
    }

//    @Scheduled(fixedDelay = 1000)
//    fun executeTask(){
//        printMessage("执行任务: ${Date()}")
//    }
}