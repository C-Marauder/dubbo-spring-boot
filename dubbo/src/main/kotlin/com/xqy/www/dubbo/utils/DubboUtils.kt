package com.xqy.www.dubbo.utils

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.xqy.www.dubbo.service.SuperService
import org.slf4j.LoggerFactory

inline fun <reified T> T.printMessage(message: String) {
    val logger = LoggerFactory.getLogger(T::class.java)
    logger.error(message)

}

