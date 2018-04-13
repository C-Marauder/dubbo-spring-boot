package com.xqy.www.dubbo.utils

import org.slf4j.LoggerFactory

inline fun <reified T> T.printMessage(message: String) {
    val logger = LoggerFactory.getLogger(T::class.java)
    logger.debug(message)

}