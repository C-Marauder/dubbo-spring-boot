package com.xqy.www.dubbo.service

import org.springframework.beans.factory.annotation.Autowired


interface SuperService <out T>{

    fun execute(param: HashMap<String,Any>): T
}