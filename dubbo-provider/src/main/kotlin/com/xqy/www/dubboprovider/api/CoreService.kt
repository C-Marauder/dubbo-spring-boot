package com.xqy.www.dubboprovider.api



interface CoreService <out T>{

    fun execute(param: HashMap<String,String>): T
}