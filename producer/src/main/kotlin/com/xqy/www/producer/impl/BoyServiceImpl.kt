package com.xqy.www.producer.impl

import com.alibaba.dubbo.config.annotation.Service
import com.xqy.www.api.service.BaseService
import com.xqy.www.domain.dao.Boy
import com.xqy.www.dubbo.utils.printMessage

@Service(interfaceClass = BaseService::class)
class BoyServiceImpl : BaseService<Boy> {
    override fun execute(param: Any): Boy {
        printMessage(param.toString())
        return Boy(1, param.toString())
    }


}