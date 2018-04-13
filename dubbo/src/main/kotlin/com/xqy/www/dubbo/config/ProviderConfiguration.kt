package com.xqy.www.dubbo.config

import com.alibaba.dubbo.config.ApplicationConfig
import com.alibaba.dubbo.config.ProtocolConfig
import com.alibaba.dubbo.config.ProviderConfig
import com.alibaba.dubbo.config.RegistryConfig
import com.xqy.www.dubbo.utils.LOCALHOST

interface ProviderConfiguration {
    //@Bean("dubbo-annotation-provider")
    fun getApplicationConfig(): ApplicationConfig = ApplicationConfig().apply {
        name = "dubbo-annotation-provider"

    }

    //@Bean("dubbo-register")
    fun getRegisterConfig(): RegistryConfig = RegistryConfig().apply {
        protocol = "zookeeper"
        address = LOCALHOST
        timeout = 1000

    }

    //@Bean("dubbo")
    fun getProtocolConfig(): ProtocolConfig = ProtocolConfig().apply {
        name = "dubbo"
        port = 20880

    }

    // @Bean("dubbo-provider")
    fun providerConfig(): ProviderConfig = ProviderConfig().apply {
        filter = "dubboTraceFilter"
    }

}



