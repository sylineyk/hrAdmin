package com.hong.admin.dao.mapper.order;

import com.hong.admin.dao.entity.order.OrderFormal;
import com.hong.admin.dao.entity.order.OrderFormalExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderFormalMapper {
    int countByExample(OrderFormalExample example);

    int deleteByExample(OrderFormalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderFormal record);

    int insertSelective(OrderFormal record);

    List<OrderFormal> selectByExample(OrderFormalExample example);

    OrderFormal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderFormal record, @Param("example") OrderFormalExample example);

    int updateByExample(@Param("record") OrderFormal record, @Param("example") OrderFormalExample example);

    int updateByPrimaryKeySelective(OrderFormal record);

    int updateByPrimaryKey(OrderFormal record);


    PageList<OrderFormal> selectByExamplePage(OrderFormalExample example, PageBounds pageBounds);


    List<Map> selectJsInfoByParam(@Param("brokerId") int brokerId, @Param("nurseName") String nurseName, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);


    PageList<Map> selectJsInfoByParamPage(@Param("brokerId") int brokerId, @Param("nurseName") String nurseName, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate, PageBounds pageBounds);
}