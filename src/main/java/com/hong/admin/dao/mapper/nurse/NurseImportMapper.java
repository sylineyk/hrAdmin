package com.hong.admin.dao.mapper.nurse;

import com.hong.admin.dao.entity.nurse.NurseImport;
import com.hong.admin.dao.entity.nurse.NurseImportExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NurseImportMapper {
    int countByExample(NurseImportExample example);

    int deleteByExample(NurseImportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NurseImport record);

    int insertSelective(NurseImport record);

    PageList<NurseImport> selectByExample(NurseImportExample example, PageBounds pageBounds);


    List<NurseImport> selectByExampleNoPage(NurseImportExample example);


    NurseImport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NurseImport record, @Param("example") NurseImportExample example);

    int updateByExample(@Param("record") NurseImport record, @Param("example") NurseImportExample example);

    int updateByPrimaryKeySelective(NurseImport record);

    int updateByPrimaryKey(NurseImport record);
}