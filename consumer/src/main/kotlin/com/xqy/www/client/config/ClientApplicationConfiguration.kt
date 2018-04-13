package com.xqy.www.client.config

import com.alibaba.dubbo.config.ApplicationConfig
import com.alibaba.dubbo.config.RegistryConfig
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan
import com.xqy.www.dubbo.config.ConsumerConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@DubboComponentScan("com.xqy.www.client")
class ClientApplicationConfiguration : ConsumerConfiguration {
    @Bean("dubbo-annotation-consumer")
    override fun getApplicationConfig(): ApplicationConfig {
        return super.getApplicationConfig()
    }

    @Bean("dubbo-register")
    override fun getRegisterConfig(): RegistryConfig {
        return super.getRegisterConfig()
    }
}