package com.xqy.www.dubbo.controller

import com.xqy.www.dubbo.param.JsonResult
import com.xqy.www.dubbo.utils.INTERFACE_NAME
import com.xqy.www.dubbo.utils.printMessage


interface DubboController {

    fun dispatchApplicationService(param: HashMap<String, Any>): JsonResult<*> {
        val interfaceName = param[INTERFACE_NAME] as String
        printMessage(interfaceName)
        //val JsonResult = JsonResult<>()
        try {

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return JsonResult("1", "成功", null)
    }
}