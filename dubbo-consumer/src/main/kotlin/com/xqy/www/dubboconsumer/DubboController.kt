package com.xqy.www.dubboconsumer

import com.xqy.www.commom.MESSAGE_FAIL
import com.xqy.www.commom.MESSAGE_SUCCESS
import com.xqy.www.commom.STATUS_FAIL
import com.xqy.www.commom.STATUS_SUCCESS
import com.xqy.www.dubboconsumer.constant.INTERFACE_NAME
import com.xqy.www.dubboconsumer.json.JsonResult
import com.xqy.www.dubboconsumer.service.DubboGenericService
import org.springframework.beans.factory.annotation.Autowired


abstract class DubboController {

    @Autowired
    private lateinit var dubboGenericService: DubboGenericService
    open fun dispatchApplicationService(param: HashMap<String, String>): JsonResult =
        JsonResult().apply {
            try {
                val genericService= dubboGenericService.getGenericService()
                val result = genericService.`$invoke`(param[INTERFACE_NAME] as String, arrayOf("java.util.Map"), arrayOf(param))
                if (result != null) {
                    data = result
                }
                message = MESSAGE_SUCCESS
                status = STATUS_SUCCESS


            } catch (e: Exception) {
                message = MESSAGE_FAIL
                status = STATUS_FAIL

                e.printStackTrace()
            }

        }



}