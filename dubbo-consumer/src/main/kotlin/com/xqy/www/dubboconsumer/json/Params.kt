package com.xqy.www.dubboconsumer.json

import java.io.Serializable

data class JsonResult(var status: String?=null, var message: String?=null, var data: Any? = null):Serializable