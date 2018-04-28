package com.xqy.www.api.service

import com.xqy.www.commom.utils.printMessage
import com.xqy.www.dubboprovider.api.CoreService
import com.xqy.www.task.constant.*
import com.xqy.www.task.manager.QuartzManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("subscribe")
class SubscriptionServiceImpl:CoreService<String> {
    @Autowired
    private lateinit var quartzManager: QuartzManager
    override fun execute(param: HashMap<String, String>): String {
        try {
            val name = param[TASK_SERVICE_NAME]
            val taskType = param[TASK_TYPE]
            when(taskType){
                INSERT-> quartzManager.executeJob(name!!,{
                    jobDataMap ->  jobDataMap[TASK_SERVICE_NAME] = name
                    jobDataMap
                },{
                    it.withIntervalInSeconds(3).repeatForever()
                })
                CANCEL-> quartzManager.pauseJob(name!!)
                UPDATE-> quartzManager.resumeJob(name!!)

            }
        }catch (e:Exception){
            printMessage("${e.message}")
        }


        return ""
    }
}