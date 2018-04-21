package com.xqy.www.api.service

import com.xqy.www.dubboprovider.api.CoreService
import com.xqy.www.mybatis.dao.AppTab
import com.xqy.www.mybatis.mapper.AppTabMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("boy")
class BoyServiceImpl : CoreService<List<AppTab>> {

    @Autowired
    private lateinit var appTabMapper: AppTabMapper
    override fun execute(param: HashMap<String,String>): List<AppTab> {
        return appTabMapper.selectAll()
    }


}