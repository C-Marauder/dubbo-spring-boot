package com.xqy.www.dubboprovider.factory

import com.alibaba.dubbo.config.*
import com.alibaba.dubbo.rpc.service.GenericService
import com.xqy.www.commom.CORE_SERVICE
import com.xqy.www.commom.LOCALHOST
import com.xqy.www.commom.PROCOTOL
import com.xqy.www.commom.VERSION
import com.xqy.www.commom.utils.printMessage

import com.xqy.www.dubboprovider.service.DubboGenericService
import com.xqy.www.dubboprovider.constant.*
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

/**
 * @program: dubbo-spring-boot
 *
 * @description: 用于初始化泛化调用核心类
 *
 * @author: XIEQIONGYU 敲代码的小灰灰
 *
 * @create: 2018-04-14 16:07
 **/
@Component
class DubboGenericServiceFactory {


    //懒加载DubboGenericService实例
    private val dubboGenericService:GenericService by lazy {
        DubboGenericService()
    }
    // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存

    private val serviceConfig:ServiceConfig<GenericService> by lazy {
        ServiceConfig<GenericService>()
    }
    private val applicationConfig:ApplicationConfig by lazy {
        ApplicationConfig().apply {
            name = DUBBO_PROVIDEER_NAME
        }
    }
    private val registryConfig:RegistryConfig by lazy {
        RegistryConfig().apply {
            protocol = PROCOTOL
            address = LOCALHOST
            timeout = TIME_OUT

        }
    }
    private val protocolConfig:ProtocolConfig by lazy {
        ProtocolConfig().apply {
            name = PROTOCOL_NAME
            port = DUBBO_PORT
        }
    }
//    private val providerConfig:ProviderConfig by lazy {
//        ProviderConfig().apply {
//            filter = FILTER
//
//        }
//    }
    @PostConstruct
    fun init(){
        serviceConfig.application = applicationConfig
        serviceConfig.registry = registryConfig
        serviceConfig.protocol = protocolConfig
//        serviceConfig.provider = providerConfig
        // 弱类型接口名
        serviceConfig.`interface` = CORE_SERVICE
        serviceConfig.version = VERSION
        // 指向一个通用服务实现
        serviceConfig.ref = dubboGenericService

        // 暴露及注册服务
        serviceConfig.export()
        printMessage("服务暴露成功^_^")
    }
}