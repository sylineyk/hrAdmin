package com.hong.admin.security.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by syline on 2017/8/15.
 */
public class UserInfo extends User {
    private static final long serialVersionUID = 1L;

    private String name;
    private int id;

    public UserInfo(String username, String password,
                    Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}