package com.xqy.www.producer.service

import com.xqy.www.domain.dao.Boy
import com.xqy.www.dubbo.service.SuperService
import org.springframework.stereotype.Service

@com.alibaba.dubbo.config.annotation.Service(interfaceClass = SuperService::class)
class BoyServiceImpl : SuperService<Boy> {
    override fun execute(param: HashMap<String,Any>): Boy {

        return Boy( param["name"] as String,"---")
    }


}