package com.xqy.www.dubbo.manager

import com.xqy.www.dubbo.service.SuperService

object DubboServiceManager {
    private val serviceMap:HashMap<String,SuperService<*>> by lazy {
        hashMapOf<String,SuperService<*>>()
    }
    fun saveService(serviceName:String,service: SuperService<*>){
        serviceMap[serviceName] = service
    }

    fun getService(serviceName:String):SuperService<*> = with(serviceName){
        serviceMap[serviceName]!!
    }
}