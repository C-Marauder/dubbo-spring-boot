package com.xqy.www.producer.service

import com.alibaba.dubbo.config.annotation.Service
import com.xqy.www.dubbo.service.SuperService
import com.xqy.www.mybatis.dao.AppTab
import com.xqy.www.mybatis.mapper.AppTabMapper
import com.xqy.www.producer.ProducerApplication

@Service
class BoyServiceImpl : SuperService<List<AppTab>> {
//    @Autowired
//    private lateinit var appTabMapper: AppTabMapper
    override fun execute(param: HashMap<String,Any>): List<AppTab> {
        val mapper = ProducerApplication.producerContext.getBean("appTabMapper") as AppTabMapper
        return mapper.selectAll()
    }


}