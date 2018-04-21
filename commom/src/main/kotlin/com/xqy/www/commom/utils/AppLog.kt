package com.xqy.www.commom.utils

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
@Aspect
class AppLog {
    private val logger by lazy {
        LoggerFactory.getLogger(this::class.simpleName)
    }
    @Pointcut("execution(public * com.xqy.www.dubboconsumer.filter..*.*(..))")
    fun applicationLog(){

    }
}