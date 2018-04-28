package com.xqy.www.dubboprovider.context

import com.xqy.www.commom.utils.printMessage
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component
@Component
class AppContext:ApplicationContextAware {
    companion object {
        lateinit var applicationContext:ApplicationContext
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        printMessage("上下文初始化成功")
        AppContext.applicationContext = applicationContext
    }


}