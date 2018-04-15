package com.xqy.www.client.controller

import com.xqy.www.dubbo.controller.DubboController
import com.xqy.www.dubbo.param.JsonResult
import com.xqy.www.dubbo.utils.printMessage
import org.springframework.boot.jackson.JsonObjectSerializer
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
class ApplicationController : DubboController {

    @RequestMapping("/action",method = [(RequestMethod.POST)])
    override fun dispatchApplicationService(@RequestBody param: HashMap<String, Any>): JsonResult {
        printMessage(param.keys.toString())
        return super.dispatchApplicationService(param)
    }
    @RequestMapping("/message")
    fun getMessage():String{
        return "测试"
    }
}