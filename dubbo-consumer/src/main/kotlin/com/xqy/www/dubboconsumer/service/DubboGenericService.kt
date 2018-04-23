package com.xqy.www.dubboconsumer.service

import com.alibaba.dubbo.config.ApplicationConfig
import com.alibaba.dubbo.config.ConsumerConfig
import com.alibaba.dubbo.config.ReferenceConfig
import com.alibaba.dubbo.config.RegistryConfig
import com.alibaba.dubbo.config.utils.ReferenceConfigCache
import com.alibaba.dubbo.rpc.service.GenericService
import com.xqy.www.commom.CORE_SERVICE
import com.xqy.www.commom.LOCALHOST
import com.xqy.www.commom.PROCOTOL
import com.xqy.www.commom.VERSION
import com.xqy.www.commom.utils.printMessage
import com.xqy.www.dubboconsumer.constant.APPLICATION_NAME
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DubboGenericService {

    private var reference: ReferenceConfig<GenericService>? = null
    @PostConstruct
    fun init() {
        if (reference == null) {
            reference = ReferenceConfig()
            reference!!.application = ApplicationConfig().apply {
                name = APPLICATION_NAME
            }
            reference!!.registry = RegistryConfig().apply {
                protocol = PROCOTOL
                address = LOCALHOST

            }
            reference!!.consumer = ConsumerConfig().apply {
                //                filter = "dubboTraceFilter"
                isGeneric = true
            }
            reference!!.`interface` = CORE_SERVICE //弱类型接口名
            reference!!.version = VERSION
            reference!!.isGeneric = true //声明为泛化接口

            printMessage("服务消费创建成功")
        }
    }

    fun getGenericService(): GenericService {
        val cache = ReferenceConfigCache.getCache()
        return cache.get(reference) ?: reference!!.get()
    }
}