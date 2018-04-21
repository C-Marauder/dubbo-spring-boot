package com.xqy.www.rocketmq.producer

import com.xqy.www.commom.utils.printMessage
import com.xqy.www.rocketmq.constant.NAMESRVADDR
import com.xqy.www.rocketmq.constant.PRODUCER_GROUP
import com.xqy.www.rocketmq.entity.MessageResult
import org.apache.rocketmq.client.producer.DefaultMQProducer
import org.apache.rocketmq.common.message.Message
import org.apache.rocketmq.remoting.common.RemotingHelper
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.charset.Charset
import javax.annotation.PostConstruct
//cd distribution/target/apache-rocketmq
//nohup sh bin/mqnamesrv &
@Component
class MQMessageProducer{
    @Value(PRODUCER_GROUP)
    private lateinit var producerGroup:String
    @Value(NAMESRVADDR)
    private lateinit var namesrvAddr:String
    private var mqProducer:DefaultMQProducer?=null
    @PostConstruct
    fun initMQProducer(){
        try {
            if (mqProducer == null){
                mqProducer = DefaultMQProducer(producerGroup)
            }
            mqProducer!!.namesrvAddr = namesrvAddr
            mqProducer!!.start()
            printMessage("MQProducer创建成功")
        }catch (e:Exception){
            e.printStackTrace()
        }finally {
            mqProducer!!.shutdown()
        }


    }

    fun pushMessage(topic:String,title:String,body:String):MessageResult{
        val message = Message(topic,"推送:",body.toByteArray(Charset.forName(RemotingHelper.DEFAULT_CHARSET)))
//        val stop = StopWatch()
//        stop.start()
        message.delayTimeLevel = 3
        val result = mqProducer?.send(message)
        printMessage("发送响应:----${result?.msgId}${result?.sendStatus}")
        return MessageResult(title,body)
    }

}