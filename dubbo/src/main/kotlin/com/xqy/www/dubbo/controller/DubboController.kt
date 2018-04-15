package com.xqy.www.dubbo.controller

import com.alibaba.dubbo.config.ApplicationConfig
import com.alibaba.dubbo.config.ConsumerConfig
import com.alibaba.dubbo.config.ReferenceConfig
import com.alibaba.dubbo.config.RegistryConfig
import com.alibaba.dubbo.rpc.service.GenericService
import com.xqy.www.dubbo.param.JsonResult
import com.xqy.www.dubbo.service.DubboGenericService
import com.xqy.www.dubbo.utils.*
import com.alibaba.dubbo.config.utils.ReferenceConfigCache




interface DubboController {

    fun dispatchApplicationService(param: HashMap<String,Any>): JsonResult {
        val jsonResult = JsonResult()
        try {
//            val params= JSON.toJSON(param) as JSONObject//接收的参数转换为json对象
//            val hashMap = hashMapOf<String,Any>()
//            params.forEach { t, u ->
//                hashMap[t] = u
//            }
//            printMessage(params[INTERFACE_NAME].toString())
//            val interfaceName = params[INTERFACE_NAME]//获取接口名称

            val reference = ReferenceConfig<GenericService>()

            reference.application = ApplicationConfig().apply {
                name = "dubbo-annotation-consumer"
            }
            reference.registry = RegistryConfig().apply {
                protocol = PROCOTOL
                address = LOCALHOST

            }
            reference.consumer = ConsumerConfig().apply {
                isGeneric = true
            }
            reference.`interface` = SUPER_SERVICE //弱类型接口名
            reference.version = VERSION
            reference.isGeneric  =true //声明为泛化接口
            val cache = ReferenceConfigCache.getCache()
            val genericService = cache.get(reference)
            printMessage(genericService.toString())

            val result = genericService.`$invoke`(param[INTERFACE_NAME]as String, arrayOf("java.util.Map"), arrayOf(param))
            jsonResult.apply {
                if (result!=null) data = result
                message = MESSAGE_SUCCESS
                status = STATUS_SUCCESS
            }

        } catch (e: Exception) {
            jsonResult.apply {
                message = MESSAGE_FAIL
                status = STATUS_FAIL
            }
            e.printStackTrace()
        }

        return jsonResult
    }
}