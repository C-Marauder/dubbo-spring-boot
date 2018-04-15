package com.xqy.www.dubbo.config

import com.alibaba.dubbo.config.ApplicationConfig
import com.alibaba.dubbo.config.ProtocolConfig
import com.alibaba.dubbo.config.ProviderConfig
import com.alibaba.dubbo.config.RegistryConfig
import com.xqy.www.dubbo.utils.DUBBO_PORT
import com.xqy.www.dubbo.utils.LOCALHOST
import com.xqy.www.dubbo.utils.PROCOTOL
import com.xqy.www.dubbo.utils.TIME_OUT

interface ProviderConfiguration {
    //@Bean("dubbo-annotation-provider")
    fun getApplicationConfig(): ApplicationConfig = ApplicationConfig().apply {
        name = "dubbo-annotation-provider"

    }

    //@Bean("dubbo-register")
    fun getRegisterConfig(): RegistryConfig = RegistryConfig().apply {
        protocol = PROCOTOL
        address = LOCALHOST
        timeout = TIME_OUT

    }

    //@Bean("dubbo")
    fun getProtocolConfig(): ProtocolConfig = ProtocolConfig().apply {
        name = "dubbo"
        port = DUBBO_PORT

    }

    // @Bean("dubbo-provider")
    fun providerConfig(): ProviderConfig = ProviderConfig().apply {
        filter = "dubboTraceFilter"
    }

}



