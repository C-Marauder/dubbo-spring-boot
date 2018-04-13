package com.xqy.www.api.service

interface BaseService<out T> {

    fun execute(param: Any): T
}