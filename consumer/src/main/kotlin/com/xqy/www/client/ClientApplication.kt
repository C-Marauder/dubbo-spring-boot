package com.xqy.www.client

import com.xqy.www.client.config.ClientApplicationConfiguration
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext

@SpringBootApplication
class ClientApplication

private val logger: Logger by lazy {
    LoggerFactory.getLogger(ClientApplication::class.java)
}

fun main(args: Array<String>) {
    AnnotationConfigApplicationContext().apply {
        register(ClientApplicationConfiguration::class.java)
        refresh()
    }
    logger.debug("consumer 服务启动 ^_^")
    runApplication<ClientApplication>(*args)
}
