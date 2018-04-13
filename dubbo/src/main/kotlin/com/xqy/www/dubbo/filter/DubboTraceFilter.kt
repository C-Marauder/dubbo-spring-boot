package com.xqy.www.dubbo.filter

import com.alibaba.dubbo.common.Constants
import com.alibaba.dubbo.common.extension.Activate
import com.alibaba.dubbo.common.logger.LoggerFactory
import com.alibaba.dubbo.rpc.*
import com.alibaba.dubbo.rpc.service.GenericService
import com.google.gson.Gson

@Activate(group = [Constants.PROVIDER], order = -999)
class DubboTraceFilter : Filter {
    companion object {
        private val logger = LoggerFactory.getLogger(DubboTraceFilter::class.java)

    }

    private val gson: Gson by lazy {
        Gson()
    }

    override fun invoke(invoker: Invoker<*>?, invocation: Invocation?): Result {
        try {
            val interfaceName = invocation!!.invoker.`interface`.name
            val methodName = invocation.methodName
            val param = invocation.arguments
            val filterResult = FilterResult(interfaceName, methodName, param)
            logger.debug("请求参数: " + gson.toJson(filterResult))
            val result = invoker!!.invoke(invocation)
            if (result.hasException() && invoker.`interface` != GenericService::class.java) {
                logger.error("执行异常: ", result.exception)
            } else {
                logger.error("执行成功:^_^")
                val successResult = FilterResult(invocation.invoker.`interface`.name, invocation.methodName, result.value)
                logger.debug("返回参数:" + gson.toJson(successResult))
            }

            return result
        } catch (e: Exception) {
            logger.error("未知异常:~_~" + RpcContext.getContext().remoteHost
                    + ". service: " + invoker!!.`interface`.name + ", method: " + invocation!!.methodName
                    + ", exception: " + e::class.java.name + ": " + e.message, e)
            throw e
        }
    }


}