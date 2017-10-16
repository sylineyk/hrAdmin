package com.hong.admin.dao.mapper.order;

import com.hong.admin.dao.entity.order.NonStandardOrderAppDetail;
import com.hong.admin.dao.entity.order.NonStandardOrderAppDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NonStandardOrderAppDetailMapper {
    int countByExample(NonStandardOrderAppDetailExample example);

    int deleteByExample(NonStandardOrderAppDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NonStandardOrderAppDetail record);

    int insertSelective(NonStandardOrderAppDetail record);

    List<NonStandardOrderAppDetail> selectByExample(NonStandardOrderAppDetailExample example);

    NonStandardOrderAppDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NonStandardOrderAppDetail record, @Param("example") NonStandardOrderAppDetailExample example);

    int updateByExample(@Param("record") NonStandardOrderAppDetail record, @Param("example") NonStandardOrderAppDetailExample example);

    int updateByPrimaryKeySelective(NonStandardOrderAppDetail record);

    int updateByPrimaryKey(NonStandardOrderAppDetail record);
}