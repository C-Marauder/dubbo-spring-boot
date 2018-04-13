package com.xqy.www.dubbo.config

import com.alibaba.dubbo.common.utils.NetUtils.LOCALHOST
import com.alibaba.dubbo.config.ApplicationConfig
import com.alibaba.dubbo.config.RegistryConfig

interface ConsumerConfiguration {

    //    @Bean("dubbo-annotation-consumer")
    fun getApplicationConfig(): ApplicationConfig = ApplicationConfig().apply {
        name = "dubbo-annotation-consumer"
    }

    //    @Bean("dubbo-register")
    fun getRegisterConfig(): RegistryConfig = RegistryConfig().apply {
        protocol = "zookeeper"
        address = LOCALHOST

    }

}




