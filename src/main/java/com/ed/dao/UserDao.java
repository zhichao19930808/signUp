package com.ed.dao;

import com.ed.domain.User;

public interface UserDao {
    /**
     * 添加用户信息
     */
    public void addUser(User user);

    /**
     * 通过用户名查询账号是否已存在
     */
    public boolean findUser(User user,String come);

}
