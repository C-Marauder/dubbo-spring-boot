package com.xqy.www.dubbo.param

data class RequestParam<out P>(val interfaceName: String, val param: P)

data class JsonResult(var status: String?=null, var message: String?=null, var data: Any? = null)