package com.xqy.www.producer.config

import com.alibaba.dubbo.config.*
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan
import com.xqy.www.dubbo.config.ProviderConfiguration
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


@Configuration
@ComponentScan(basePackages = ["com.xqy.www.producer.service"] )
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

//    @Bean("dubbo-provider")
//    override fun providerConfig(): ProviderConfig {
//        return super.providerConfig()
//    }
}