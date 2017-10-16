package com.hong.admin.security.dao;


import com.hong.admin.security.domain.Permission;

import java.util.List;

/**
 * Created by yangyibo on 17/1/20.
 */
public interface PermissionDao {
    public List<Permission> findAll();

    public List<Permission> findByAdminUserId(int userId);
}
