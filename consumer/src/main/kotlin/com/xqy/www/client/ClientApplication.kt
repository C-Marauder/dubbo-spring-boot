package com.xqy.www.client
import org.apache.zookeeper.ZooKeeperMain.printMessage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.xqy.www.dubboconsumer","com.xqy.www.client.controller","com.xqy.www.rocketmq.consumer")
class ClientApplication


fun main(args: Array<String>) {
    runApplication<ClientApplication>(*args)
    printMessage("consumer 服务启动 ^_^")
//

}
