package com.xqy.www.mybatis.dao

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "app_tab")
data class AppTab(@Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY) val id:Int, val name:String):Serializable