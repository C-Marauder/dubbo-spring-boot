package com.xqy.www.mybatis.dao

import java.io.Serializable
import javax.persistence.*

//@Table(name = "app_tab")
//data class AppTab(@Id
                 // @GeneratedValue(strategy = GenerationType.IDENTITY) val id:Int, val name:String):Serializable



@Table(name = "`app_tab`")
class AppTab {
    /**
     * @return id
     */
    /**
     * @param id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    /**
     * @return name
     */
    /**
     * @param name
     */
    @Column(name = "`name`")
    var name: String? = null
}