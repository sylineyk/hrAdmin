package com.hong.admin.dao.mapper.nurse;

import com.hong.admin.dao.entity.nurse.NurseImg;
import com.hong.admin.dao.entity.nurse.NurseImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NurseImgMapper {
    int countByExample(NurseImgExample example);

    int deleteByExample(NurseImgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NurseImg record);

    int insertSelective(NurseImg record);

    List<NurseImg> selectByExample(NurseImgExample example);

    NurseImg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NurseImg record, @Param("example") NurseImgExample example);

    int updateByExample(@Param("record") NurseImg record, @Param("example") NurseImgExample example);

    int updateByPrimaryKeySelective(NurseImg record);

    int updateByPrimaryKey(NurseImg record);
}