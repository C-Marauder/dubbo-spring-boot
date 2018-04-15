package com.xqy.www.dubbo.service

import com.alibaba.dubbo.config.spring.ServiceBean
import com.alibaba.dubbo.rpc.service.GenericService
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
    private val context:AnnotationConfigApplicationContext by lazy {
        AnnotationConfigApplicationContext { refresh() }
    }
    override fun `$invoke`(method: String?, parameterTypes: Array<out String>?, args: Array<out Any>?): Any {
        if (method== null||args == null){
            return "接口名或参数为空"
        }
        val map = context.getBeansOfType(SuperService::class.java)
        map.forEach { t, u ->
            printMessage("$t-----$u")
        }
        val service = context.getBean(method) as SuperService<*>
        return service.execute(args[0] as HashMap<String, Any>)!!
    }
}