package com.xqy.www.rocketmq.consumer

import com.xqy.www.commom.utils.printMessage
import com.xqy.www.rocketmq.constant.MQCONSUMER_GROUP
import com.xqy.www.rocketmq.constant.MQCONSUMER_INSTANCE_NAME
import com.xqy.www.rocketmq.constant.NAMESRVADDR
import com.xqy.www.rocketmq.listener.MQMessageListener
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct


@Component
class MQMessageConsumer {

    @PostConstruct
    fun initMQConsumer(){
        // Instantiate message consumer
        val consumer = DefaultMQPushConsumer(MQCONSUMER_GROUP)
        // //nameserver服务
        consumer.namesrvAddr = NAMESRVADDR
        consumer.instanceName = MQCONSUMER_INSTANCE_NAME

        consumer.subscribe("test","*")
        consumer.registerMessageListener(MQMessageListener())
        consumer.start()
        printMessage("MQMessageConsumer 创建成功")
    }
}