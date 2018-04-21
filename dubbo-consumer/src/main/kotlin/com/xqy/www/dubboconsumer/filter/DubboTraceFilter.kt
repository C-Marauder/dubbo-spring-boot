package com.xqy.www.dubboconsumer.filter

import com.alibaba.dubbo.common.Constants
import com.alibaba.dubbo.common.extension.Activate
import com.alibaba.dubbo.common.logger.LoggerFactory
import com.alibaba.dubbo.rpc.*
import com.alibaba.dubbo.rpc.service.GenericService
import com.xqy.www.commom.utils.toJsonString

@Activate(group = [Constants.CONSUMER],order = -999)
class DubboTraceFilter : Filter {

    private val logger by lazy {
        LoggerFactory.getLogger("请求信息::")
    }

    override fun invoke(invoker: Invoker<*>?, invocation: Invocation?): Result {
        try {
            val interfaceName = invocation!!.invoker.`interface`.name
            val methodName = invocation.methodName
            val param = invocation.arguments
            val filterResult = FilterResult(interfaceName, methodName, param)
            logger.info("请求参数: " + filterResult.param.toJsonString())
            val result = invoker!!.invoke(invocation)
            if (result != null) {
                if (result.hasException() && invoker.`interface` != GenericService::class.java) {
                    logger.error("执行异常: ", result.exception)
                } else {
                    logger.info("执行成功:^_^")

                    val successResult = FilterResult(invocation.invoker.`interface`.name, invocation.methodName, result.value)
                    logger.info("返回参数:" + successResult.param.toJsonString())
                }

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