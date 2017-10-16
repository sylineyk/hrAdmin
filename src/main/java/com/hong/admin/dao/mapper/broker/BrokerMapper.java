package com.hong.admin.dao.mapper.broker;

import com.hong.admin.dao.entity.broker.Broker;
import com.hong.admin.dao.entity.broker.BrokerExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface BrokerMapper {
    int countByExample(BrokerExample example);

    int deleteByExample(BrokerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Broker record);

    int insertSelective(Broker record);

    PageList<Broker> selectByExample(BrokerExample example, PageBounds pageBounds);

    Broker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Broker record, @Param("example") BrokerExample example);

    int updateByExample(@Param("record") Broker record, @Param("example") BrokerExample example);

    int updateByPrimaryKeySelective(Broker record);

    int updateByPrimaryKey(Broker record);

    Map selectBrokerInfoById(@Param("brokerId") int brokerId);

    PageList<Map> selectBrokerInfoByParam(@Param("param") String param, PageBounds pageBounds);

    String selectBrokerNmaeByPhone(@Param("phone") String phone);

    int updateByPhoneNum(@Param("password") String password, @Param("phoneNumber") String phoneNumber);
}