package com.xqy.www.mybatis.mapper.base;

import java.util.List;

import com.xqy.www.mybatis.dao.AppTab;
/**
*  @author author
*/
public interface AppTabBaseMapper {

    int insertAppTab(AppTab object);

    int updateAppTab(AppTab object);

    List<AppTab> queryAppTab(AppTab object);

    AppTab queryAppTabLimit1(AppTab object);

}