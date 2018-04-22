package com.xqy.www.rocketmq.producer

import com.xqy.www.commom.utils.printMessage
import com.xqy.www.rocketmq.constant.MQPRODUCER_GROUP
import com.xqy.www.rocketmq.constant.MQPRODUCER_INSTANCE_NAME
import com.xqy.www.rocketmq.constant.NAMESRVADDR
import com.xqy.www.rocketmq.entity.MessageResult
import org.apache.rocketmq.client.producer.DefaultMQProducer
import org.apache.rocketmq.client.producer.SendCallback
import org.apache.rocketmq.client.producer.SendResult
import org.apache.rocketmq.common.message.Message
import org.apache.rocketmq.remoting.common.RemotingHelper
import org.springframework.stereotype.Component
import java.nio.charset.Charset
import javax.annotation.PostConstruct

//cd distribution/target/apache-rocketmq
//nohup sh bin/mqnamesrv &
@Component
class MQMessageProducer{


    private lateinit var mqProducer:DefaultMQProducer
    @PostConstruct
    fun initMQProducer(){

        try {

            mqProducer = DefaultMQProducer(MQPRODUCER_GROUP)
            mqProducer.namesrvAddr = NAMESRVADDR
            mqProducer.instanceName = MQPRODUCER_INSTANCE_NAME

            mqProducer.start()
            val message = Message("test","haahh","我是小辉辉".toByteArray(Charset.forName(RemotingHelper.DEFAULT_CHARSET)))
//        message.delayTimeLevel = 3
            val result = mqProducer.send(message,object :SendCallback{
                override fun onSuccess(sendResult: SendResult?) {
                    printMessage(sendResult!!.msgId+sendResult.sendStatus)
                }

                override fun onException(e: Throwable?) {
                    printMessage("exception:----${e!!.message}")

                }

            })
            printMessage("MQProducer创建成功${mqProducer.producerGroup}${mqProducer.instanceName}---")
        }catch (e:Exception){
            e.printStackTrace()
        }finally {
            //mqProducer!!.shutdown()
        }


    }

    fun pushMessage(topic:String,title:String,body:String):MessageResult{
        val message = Message("test",title,body.toByteArray(Charset.forName(RemotingHelper.DEFAULT_CHARSET)))
//        message.delayTimeLevel = 3
        val result = mqProducer.send(message,object :SendCallback{
            override fun onSuccess(sendResult: SendResult?) {
                printMessage(sendResult!!.msgId+sendResult.sendStatus)
            }

            override fun onException(e: Throwable?) {
                printMessage("exception:----${e!!.message}")

            }

        })
        mqProducer.shutdown()
        return MessageResult(title,body)
    }

}