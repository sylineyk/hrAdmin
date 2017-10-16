package com.hong.admin.dao.mapper.order;

import com.hong.admin.dao.entity.order.PayOrder;
import com.hong.admin.dao.entity.order.PayOrderExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PayOrderMapper {
    int countByExample(PayOrderExample example);

    int deleteByExample(PayOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayOrder record);

    int insertSelective(PayOrder record);

    List<PayOrder> selectByExample(PayOrderExample example);

    PayOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayOrder record, @Param("example") PayOrderExample example);

    int updateByExample(@Param("record") PayOrder record, @Param("example") PayOrderExample example);

    int updateByPrimaryKeySelective(PayOrder record);

    int updateByPrimaryKey(PayOrder record);


    PageList<PayOrder> selectByExamplePage(PayOrderExample example, PageBounds pageBounds);


    PageList<Map> selectJjrDetailByDate(@Param("fromDate") Date fromDate, @Param("endDate") Date endDate, PageBounds pageBounds);

    PageList<Map> selectAyDetailByDate(@Param("fromDate") Date fromDate, @Param("endDate") Date endDate, PageBounds pageBounds);
}