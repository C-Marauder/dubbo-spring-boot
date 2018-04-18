package com.xqy.www.producer.service

import com.xqy.www.dubbo.service.SuperService
import com.xqy.www.mybatis.dao.AppTab
import com.xqy.www.mybatis.mapper.AppTabMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BoyServiceImpl : SuperService<List<AppTab>> {
    @Autowired
    private lateinit var appTabMapper: AppTabMapper
    override fun execute(param: HashMap<String,Any>): List<AppTab> {
        return appTabMapper.selectAll()
    }


}