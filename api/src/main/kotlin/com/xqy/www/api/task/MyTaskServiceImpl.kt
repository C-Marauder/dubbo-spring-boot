package com.xqy.www.api.task

import com.xqy.www.commom.utils.printMessage
import com.xqy.www.task.service.ScheduledTaskService
import org.springframework.stereotype.Service

/**
 * @program: dubbo-spring-boot
 *
 * @description: 测试类
 *
 * @author: XIEQIONGYU 敲代码的小灰灰
 *
 * @create: 2018-04-26 19:40
 **/
@Service("test")
class MyTaskServiceImpl:ScheduledTaskService {
    override fun executeTask(obj: Any) {
        printMessage(obj.toString())
    }
}