package com.ed.service;

import com.ed.domain.User;

public interface UserService {
    /**
     * 查询格式是否正确
     */
    public boolean validate(User user);
    /**
     * 查询是否存在
     */
    public boolean quesyByName(User user);

    /**
     * 验证正确则开始注册
     * @param user
     */
    public void signUp(User user);
}
