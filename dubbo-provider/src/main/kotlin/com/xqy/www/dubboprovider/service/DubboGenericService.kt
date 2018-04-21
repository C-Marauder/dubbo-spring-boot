package com.xqy.www.dubboprovider.service

import com.alibaba.dubbo.rpc.service.GenericService
import com.xqy.www.dubboprovider.api.CoreService
import com.xqy.www.dubboprovider.manager.DubboServiceManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


/**
 * @program: dubbo-spring-boot
 *
 * @description: dubbo泛化调用的核心类
 *
 * @author: XIEQIONGYU 敲代码的小灰灰
 *
 * @create: 2018-04-14 15:27
 **/
class DubboGenericService:GenericService {

    override fun `$invoke`(method: String?, parameterTypes: Array<out String>?, args: Array<out Any>?): Any {
        var result :Any ?
        try {
            result = DubboServiceManager.getService(method!!).execute(args!![0] as HashMap<String, String>)

        }catch (e:Exception){
            result = "参数不正确"
            e.printStackTrace()
        }

        return result!!
    }
}