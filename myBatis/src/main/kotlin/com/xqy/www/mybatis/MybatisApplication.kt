//package com.xqy.www.mybatis
//
//import com.xqy.www.mybatis.config.ProducerConfiguration
//import com.xqy.www.mybatis.dao.AppTab
//import com.xqy.www.mybatis.mapper.AppTabMapper
//import org.mybatis.spring.annotation.MapperScan
//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.CommandLineRunner
//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication
//import org.springframework.context.annotation.AnnotationConfigApplicationContext
//
//@SpringBootApplication
//@MapperScan("com.xqy.www.mybatis.mapper")
//class MybatisApplication {
//
//
//
//}
//private val logger: Logger by lazy {
//    LoggerFactory.getLogger(MybatisApplication::class.java)
//}
//fun main(args: Array<String>) {
//    val context = AnnotationConfigApplicationContext {
//
//        register(ProducerConfiguration::class.java)
//
//        refresh()
//
//    }
//    runApplication<MybatisApplication>(*args)
//    try {
//        System.`in`.read()
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }
//}
