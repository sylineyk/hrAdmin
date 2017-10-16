package com.hong.admin.security.service;

import com.hong.admin.security.dao.PermissionDao;
import com.hong.admin.security.dao.UserDao;
import com.hong.admin.security.domain.Permission;
import com.hong.admin.security.domain.SysUser;
import com.hong.admin.security.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo on 17/1/18.
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserDao userDao;
    @Autowired
    PermissionDao permissionDao;


    public UserDetails loadUserByUsername(String username) {
        SysUser user = userDao.findByUserName(username);
        if (user != null) {
            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            UserInfo userInfo = new UserInfo(user.getUsername(), user.getPassword(), grantedAuthorities);
            userInfo.setId(user.getId());
            userInfo.setName(username);
            return userInfo;
        } else {
            throw new UsernameNotFoundException("你输入的" + username + " 不存在!");
        }
    }
}
