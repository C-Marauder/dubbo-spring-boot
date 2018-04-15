package com.xqy.www.dubbo.service

import com.alibaba.dubbo.config.spring.ServiceBean
import com.alibaba.dubbo.rpc.service.GenericService
import com.xqy.www.dubbo.manager.DubboServiceManager
import com.xqy.www.dubbo.utils.printMessage
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.AnnotationConfigApplicationContext


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
            result = DubboServiceManager.getService(method!!).execute(args!![0] as HashMap<String, Any>)

        }catch (e:Exception){
            result = "参数不正确"
            e.printStackTrace()
        }

        return result!!
    }
}