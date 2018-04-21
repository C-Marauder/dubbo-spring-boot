package com.xqy.www.dubboprovider.manager

import com.xqy.www.commom.utils.printMessage
import com.xqy.www.dubboprovider.api.CoreService
import org.springframework.beans.factory.InitializingBean
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Service

@Service
class DubboServiceManager:InitializingBean,ApplicationContextAware{
    companion object {
        private lateinit var applicationContext:ApplicationContext
        private val serviceImplMap:HashMap<String,CoreService<*>> by lazy {
            hashMapOf<String,CoreService<*>>()
        }
        fun getService(serviceName:String):CoreService<*> = serviceImplMap[serviceName]!!

    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        DubboServiceManager.applicationContext = applicationContext
    }

    override fun afterPropertiesSet() {
        printMessage("DubboServiceManager:-----afterPropertiesSet")
        val services = applicationContext.getBeansOfType(CoreService::class.java)
        services.forEach { t, u ->
            serviceImplMap[t] = u
        }
    }



}