package com.ed.domain.impl;

import com.ed.dao.UserDao;
import com.ed.dao.impl.UserDaoImpl;
import com.ed.domain.User;
import com.ed.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();


    @Override
    public boolean validate(User user) {
        if ("".equals(user.getUserName().trim())) {
            user.getMessage().put("userName", "用户名不能为空");
        } else if (!user.getUserName().trim().matches("\\w{3,8}")) {
            user.getMessage().put("userName", "用户名需为3~8位的字母");
        }
        if ("".equals(user.getPassword())) {
            user.getMessage().put("password", "密码不能为空");
        } else if (!user.getPassword().matches("\\d{3,8}")) {
            user.getMessage().put("password", "密码需为3~8位的数字");
        }
        if (!user.getPassword().equals(user.getRepassword())) {
            user.getMessage().put("repassword", "两次输入的密码不一致");
        }
        if ("".equals(user.getEmail().trim())) {
            user.getMessage().put("email", "用户名不能为空");
        } else if (!user.getEmail().trim().matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")){
            user.getMessage().put("email", "邮箱格式不正确");
        }
        if("".equals(user.getBirthday().trim())){
            user.getMessage().put("birthday", "日期不能为空！");
        }else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                format.parse(user.getBirthday());
            } catch (ParseException e) {
                user.getMessage().put("birthday", "日期格式不正确");
            }
        }
        return user.getMessage().isEmpty();
    }

    @Override
    public boolean quesyByName(User user) {
        boolean find = userDao.findUser(user,"signUp");
        if (find) {
            user.getMessage().put("userName", "用户名已存在");
        }
        return !find;
    }

    @Override
    public void signUp(User user) {
        System.err.println("调用signUp()");
        new UserDaoImpl().addUser(user);
    }
}
