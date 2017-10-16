package com.hong.admin.dao.mapper.order;

import com.hong.admin.dao.entity.order.OnceOrderAppDetail;
import com.hong.admin.dao.entity.order.OnceOrderAppDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OnceOrderAppDetailMapper {
    int countByExample(OnceOrderAppDetailExample example);

    int deleteByExample(OnceOrderAppDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OnceOrderAppDetail record);

    int insertSelective(OnceOrderAppDetail record);

    List<OnceOrderAppDetail> selectByExample(OnceOrderAppDetailExample example);

    OnceOrderAppDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OnceOrderAppDetail record, @Param("example") OnceOrderAppDetailExample example);

    int updateByExample(@Param("record") OnceOrderAppDetail record, @Param("example") OnceOrderAppDetailExample example);

    int updateByPrimaryKeySelective(OnceOrderAppDetail record);

    int updateByPrimaryKey(OnceOrderAppDetail record);
}