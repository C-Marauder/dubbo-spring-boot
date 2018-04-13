package com.xqy.www.producer.config

import com.alibaba.dubbo.config.ApplicationConfig
import com.alibaba.dubbo.config.ProtocolConfig
import com.alibaba.dubbo.config.ProviderConfig
import com.alibaba.dubbo.config.RegistryConfig
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan
import com.xqy.www.dubbo.config.ProviderConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@DubboComponentScan("com.xqy.www.producer")
class ProducerConfiguration : ProviderConfiguration {
    @Bean("dubbo-annotation-provider")
    override fun getApplicationConfig(): ApplicationConfig {
        return super.getApplicationConfig()
    }

    @Bean("dubbo-register")
    override fun getRegisterConfig(): RegistryConfig {
        return super.getRegisterConfig()
    }

    @Bean("dubbo")
    override fun getProtocolConfig(): ProtocolConfig {
        return super.getProtocolConfig()
    }

    @Bean("dubbo-provider")
    override fun providerConfig(): ProviderConfig {
        return super.providerConfig()
    }
}