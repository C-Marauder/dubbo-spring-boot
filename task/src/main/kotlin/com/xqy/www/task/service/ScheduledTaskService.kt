package com.xqy.www.task.service

/**
 * @program: dubbo-spring-boot
 *
 * @description: 定时任务核心接口
 *
 * @author: XIEQIONGYU 敲代码的小灰灰
 *
 * @create: 2018-04-26 19:37
 **/
interface ScheduledTaskService {
    fun executeTask(obj:Any)
}