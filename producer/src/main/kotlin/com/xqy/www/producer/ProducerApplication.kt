package com.xqy.www.producerimport com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScanimport com.xqy.www.dubbo.factory.DubboGenericServiceFactoryimport com.xqy.www.dubbo.service.SuperServiceimport com.xqy.www.dubbo.utils.printMessageimport com.xqy.www.producer.config.ProducerConfigurationimport org.apache.zookeeper.ZooKeeperMain.printMessageimport org.slf4j.Loggerimport org.slf4j.LoggerFactoryimport org.springframework.boot.autoconfigure.SpringBootApplicationimport org.springframework.boot.runApplicationimport org.springframework.context.annotation.AnnotationConfigApplicationContext@SpringBootApplication@DubboComponentScan("com.xqy.www.producer")class ProducerApplicationprivate val logger: Logger by lazy {    LoggerFactory.getLogger(ProducerApplication::class.java)}fun main(args: Array<String>) {    val context = AnnotationConfigApplicationContext {        register(ProducerConfiguration::class.java)        refresh()    }    DubboGenericServiceFactory.init()    val map = context.getBeansOfType(SuperService::class.java)    logger.debug(map.toString())    logger.debug(map.size.toString())    map.forEach { t, u ->        logger.error("$t-----$u")    }    logger.debug("provider 服务配置注册成功")    logger.debug("Provider 服务启动 ^_^")    try {        System.`in`.read()    } catch (e: Exception) {        e.printStackTrace()    }}