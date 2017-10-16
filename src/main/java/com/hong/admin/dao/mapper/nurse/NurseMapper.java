package com.hong.admin.dao.mapper.nurse;

import com.hong.admin.dao.entity.nurse.Nurse;
import com.hong.admin.dao.entity.nurse.NurseExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NurseMapper {
    int countByExample(NurseExample example);

    int deleteByExample(NurseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Nurse record);

    int insertSelective(Nurse record);

    PageList<Nurse> selectByExample(NurseExample example, PageBounds pageBounds);

    Nurse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Nurse record, @Param("example") NurseExample example);

    int updateByExample(@Param("record") Nurse record, @Param("example") NurseExample example);

    int updateByPrimaryKeySelective(Nurse record);

    int updateByPrimaryKey(Nurse record);

    PageList<Map> selectNurseInfoByParam(@Param("nurse") Nurse nurse, @Param("bokerId") int bokerId, PageBounds pageBounds);


    PageList<Map> selectShNurseByParam(@Param("brokerId") int brokerId, @Param("status") String status, PageBounds pageBounds);

    PageList<Map> selectShShNurseByParam(@Param("status") String status, PageBounds pageBounds);


    List<String> selectShPicsByParam(@Param("brokerId") int brokerId, @Param("nurseId") int nurseId, @Param("status") String status);

    List<String> selectShShPicsByParam(@Param("nurseId") int nurseId, @Param("status") String status);

    Map selectInfoByPhone(@Param("phone") String phone);

}