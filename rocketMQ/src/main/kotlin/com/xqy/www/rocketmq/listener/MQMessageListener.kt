package com.xqy.www.rocketmq.listener

import com.xqy.www.commom.utils.printMessage
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently
import org.apache.rocketmq.common.message.MessageExt

/**
 * @program: dubbo-spring-boot
 *
 * @description: mq消息接收监听
 *
 * @author: XIEQIONGYU 敲代码的小灰灰
 *
 * @create: 2018-04-21 23:26
 **/
class MQMessageListener : MessageListenerConcurrently {
    override fun consumeMessage(msgs: MutableList<MessageExt>?, context: ConsumeConcurrentlyContext?): ConsumeConcurrentlyStatus {
        msgs!!.forEach {
            printMessage("接收消息:"+it.msgId+ (System.currentTimeMillis() - it.storeTimestamp) + "ms later")
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS

    }
}