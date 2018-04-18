package com.xqy.www.dubbo.utils

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.xqy.www.dubbo.service.SuperService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
val logger:Logger by lazy {
    LoggerFactory.getLogger("敲代码的小灰灰log :")
}
inline fun <reified T> T.printMessage(message: String) {
    logger.error("${T::class.java.simpleName}----$message")

}
private val gson:JsonParser by lazy {
    JsonParser()
}
fun String.toJsonObject():JsonObject = gson.parse(this) as JsonObject

fun String.toJsonArray():JsonArray = gson.parse(this) as JsonArray

