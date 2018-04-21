package com.xqy.www.api.message

import com.xqy.www.dubboprovider.api.CoreService
import com.xqy.www.rocketmq.entity.MessageResult
import com.xqy.www.rocketmq.producer.MQMessageProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("message")
class PushMessageServiceImpl:CoreService<MessageResult> {
    @Autowired
    private lateinit var mqMessageProducer: MQMessageProducer
    override fun execute(param: HashMap<String, String>): MessageResult {
        val topic = param["topic"]
        return mqMessageProducer.pushMessage(topic!!,"发送消息","小灰灰来了!!!")
    }
}