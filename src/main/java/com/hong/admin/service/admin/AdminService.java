package com.hong.admin.service.admin;

import com.hong.admin.dao.entity.admin.SysUser;
import com.hong.admin.dao.entity.admin.SysUserExample;
import com.hong.admin.dao.mapper.admin.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syline on 2017/7/22.
 */
@Service
public class AdminService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser selectAdminInfo(String adminName) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(adminName);

        Map result = new HashMap<>();
        List<SysUser> list = sysUserMapper.selectByExample(example);
        if (list.size() > 0) {
            SysUser sysUser = list.get(0);
            return sysUser;
        }
        return null;
    }


    public int updateAdmin(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }


    /**
     * 检查密码是否正确
     *
     * @param pwd
     * @return
     */
    public boolean isPwdOk(String userName, String pwd) {
        boolean flag = false;
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(userName).andPasswordEqualTo(pwd);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        if (list.size() > 0) {
            flag = true;
        }
        return flag;
    }


    /**
     * 修改密码
     *
     * @return
     */
    public int updatePwdByAdminName(String userName, String newPwd) {
        SysUser usr = new SysUser();
        usr.setPassword(newPwd);
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(userName);

        return sysUserMapper.updateByExampleSelective(usr, example);
    }


}
