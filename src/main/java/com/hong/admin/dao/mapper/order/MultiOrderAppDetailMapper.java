package com.hong.admin.dao.mapper.order;

import com.hong.admin.dao.entity.order.MultiOrderAppDetail;
import com.hong.admin.dao.entity.order.MultiOrderAppDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MultiOrderAppDetailMapper {
    int countByExample(MultiOrderAppDetailExample example);

    int deleteByExample(MultiOrderAppDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MultiOrderAppDetail record);

    int insertSelective(MultiOrderAppDetail record);

    List<MultiOrderAppDetail> selectByExample(MultiOrderAppDetailExample example);

    MultiOrderAppDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MultiOrderAppDetail record, @Param("example") MultiOrderAppDetailExample example);

    int updateByExample(@Param("record") MultiOrderAppDetail record, @Param("example") MultiOrderAppDetailExample example);

    int updateByPrimaryKeySelective(MultiOrderAppDetail record);

    int updateByPrimaryKey(MultiOrderAppDetail record);
}