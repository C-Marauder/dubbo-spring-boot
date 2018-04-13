package com.xqy.www.client.controller

import com.xqy.www.dubbo.controller.DubboController
import com.xqy.www.dubbo.param.JsonResult
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApplicationController : DubboController {

    @RequestMapping("/action")
    override fun dispatchApplicationService(@RequestBody param: HashMap<String, Any>): JsonResult<*> {
        return super.dispatchApplicationService(param)
    }

}