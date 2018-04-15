package com.xqy.www.producer.service

import com.alibaba.dubbo.config.annotation.Service
import com.xqy.www.dubbo.service.SuperService
import com.xqy.www.producer.dao.AppTab
import com.xqy.www.producer.mapper.AppTabMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Lazy
import tk.mybatis.mapper.common.Mapper

@Service(interfaceClass = SuperService::class)
class BoyServiceImpl : SuperService<List<AppTab>> {
    @Autowired
    private lateinit var mapper: AppTabMapper
    override fun execute(param: HashMap<String,Any>): List<AppTab> {

        return mapper.selectAll()
    }


}