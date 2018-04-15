package com.xqy.www.producer.mapper

import com.xqy.www.producer.dao.AppTab
import org.apache.ibatis.annotations.Mapper

/**
 * @program: dubbo-spring-boot
 *
 * @description: mapper
 *
 * @author: XIEQIONGYU 敲代码的小灰灰
 *
 * @create: 2018-04-16 00:26
 **/
@Mapper
interface AppTabMapper {
    fun selectAll():List<AppTab>
}