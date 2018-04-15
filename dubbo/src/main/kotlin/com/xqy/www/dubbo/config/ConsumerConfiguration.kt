package com.xqy.www.dubbo.config

import com.alibaba.dubbo.config.ApplicationConfig
import com.alibaba.dubbo.config.RegistryConfig
import com.xqy.www.dubbo.utils.LOCALHOST
import com.xqy.www.dubbo.utils.PROCOTOL

interface ConsumerConfiguration {

    //    @Bean("dubbo-annotation-consumer")
    fun getApplicationConfig(): ApplicationConfig = ApplicationConfig().apply {
        name = "dubbo-annotation-consumer"
    }

    //    @Bean("dubbo-register")
    fun getRegisterConfig(): RegistryConfig = RegistryConfig().apply {
        protocol = PROCOTOL
        address = LOCALHOST

    }

}




