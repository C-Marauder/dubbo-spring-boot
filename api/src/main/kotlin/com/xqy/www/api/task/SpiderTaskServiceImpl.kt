package com.xqy.www.api.task

import com.xqy.www.commom.utils.printMessage
import com.xqy.www.task.service.ScheduledTaskService
import org.springframework.stereotype.Service

@Service("spider")
class SpiderTaskServiceImpl :ScheduledTaskService{

    override fun executeTask(obj: Any) {
        Runtime.getRuntime().exec(arrayOf("python",""))
        printMessage(obj.toString())
    }
}