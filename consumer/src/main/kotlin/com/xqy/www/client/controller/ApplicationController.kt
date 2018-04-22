package com.xqy.www.client.controller

import com.xqy.www.dubboconsumer.DubboController
import com.xqy.www.dubboconsumer.json.JsonResult
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class ApplicationController : DubboController() {

    @RequestMapping("/action",method = [(RequestMethod.POST)])
    override fun dispatchApplicationService(@RequestBody param: HashMap<String, String>): JsonResult {
        return super.dispatchApplicationService(param)
    }
    @RequestMapping("/message")
    fun getMessage():String{
        return "测试"
    }
}