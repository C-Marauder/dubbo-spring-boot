package com.xqy.www.api.task

import com.xqy.www.dubboprovider.api.CoreService
import com.xqy.www.task.manager.QuartzManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("subscribe")
class SubscriptionServiceImpl:CoreService<String> {
    @Autowired
    private lateinit var quartzManager: QuartzManager
    override fun execute(param: HashMap<String, String>): String {
        val name = param["name"]
        quartzManager.executeJob(name!!,{
            it.withIntervalInSeconds(3).repeatForever()
        })
        return "成功"
    }
}