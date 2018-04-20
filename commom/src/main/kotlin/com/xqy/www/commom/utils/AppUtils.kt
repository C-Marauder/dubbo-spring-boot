package com.xqy.www.commom.utils

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.slf4j.Logger
import org.slf4j.LoggerFactory

val logger:Logger by lazy {
    LoggerFactory.getLogger("敲代码的小灰灰log :")
}
inline fun <reified T> T.printMessage(message: String) {
    logger.info("${T::class.java.simpleName}----$message--^_^")

}
 val jsonParser:JsonParser by lazy {
    JsonParser()
}
val gson:Gson by lazy {
    Gson()
}

fun String.toJsonObject():JsonObject = jsonParser.parse(this) as JsonObject

fun String.toJsonArray():JsonArray = jsonParser.parse(this) as JsonArray

inline fun <reified T:Any> T.toJsonString():String = gson.toJson(this)





