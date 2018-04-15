package com.xqy.www.dubbo.service


interface SuperService <out T>{

    fun execute(param: HashMap<String,Any>): T
}