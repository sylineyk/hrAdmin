package com.hong.admin.security.dao;


import com.hong.admin.security.domain.SysUser;

public interface UserDao {
    public SysUser findByUserName(String username);
}
