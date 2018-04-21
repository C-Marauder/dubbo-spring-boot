package com.xqy.www.dubboconsumer.filter

import java.io.Serializable

data class FilterResult(val interfaceName: String, val methodName: String, val param: Any):Serializable
