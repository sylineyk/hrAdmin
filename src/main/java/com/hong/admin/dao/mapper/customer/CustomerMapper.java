package com.hong.admin.dao.mapper.customer;

import com.hong.admin.dao.entity.customer.Customer;
import com.hong.admin.dao.entity.customer.CustomerExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    PageList<Customer> selectByExample(CustomerExample example, PageBounds pageBounds);

    Customer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);


    PageList<Map> selectCustomerInfoByParam(@Param("param") String param, PageBounds pageBounds);
}