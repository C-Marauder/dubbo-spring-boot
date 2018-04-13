package com.xqy.www.dubbo.param

data class RequestParam<out P>(val interfaceName: String, val param: P)

data class JsonResult<T>(var status: String, var message: String, var data: T? = null)