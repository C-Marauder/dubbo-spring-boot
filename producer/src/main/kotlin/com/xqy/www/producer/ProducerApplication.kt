package com.xqy.www.producer

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan
import com.xqy.www.producer.config.ProducerConfiguration
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext

@SpringBootApplication
@DubboComponentScan("com.xqy.www.producer.impl")
class ProducerApplication

private val logger: Logger by lazy {
    LoggerFactory.getLogger(ProducerApplication::class.java)
}

fun main(args: Array<String>) {
    AnnotationConfigApplicationContext {
        register(ProducerConfiguration::class.java)
        refresh()

    }
    logger.debug("provider 服务配置注册成功")
    logger.debug("Provider 服务启动 ^_^")
    try {
        System.`in`.read()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
