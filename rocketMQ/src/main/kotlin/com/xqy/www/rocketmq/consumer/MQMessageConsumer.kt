package com.xqy.www.rocketmq.consumer

import com.xqy.www.commom.utils.printMessage
import com.xqy.www.rocketmq.constant.CONSUMER_GROUP
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct


@Component
class MQMessageConsumer {
    @Value(CONSUMER_GROUP)
    private lateinit var consumerGroup:String

    @PostConstruct
    fun initMQConsumer(){
        // Instantiate message consumer
        val consumer = DefaultMQPushConsumer(consumerGroup)
        consumer.subscribe("test","*")
        consumer.registerMessageListener(MessageListenerConcurrently { msgs, _ ->
            msgs!!.forEach {
                printMessage("接收消息:"+it.msgId+ (System.currentTimeMillis() - it.storeTimestamp) + "ms later")
            }
            ConsumeConcurrentlyStatus.CONSUME_SUCCESS

        })

        consumer.start()

    }
}