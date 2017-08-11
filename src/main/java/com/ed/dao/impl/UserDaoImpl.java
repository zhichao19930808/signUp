package com.ed.dao.impl;

import com.ed.dao.UserDao;
import com.ed.domain.User;
import com.ed.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    //验证注册信息是否合格
    public boolean findUser(User user ,String come) {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql1 = "SELECT * FROM db_test.user WHERE userName='" + user.getUserName() + "'";
        String sql2 = "SELECT * FROM db_test.user WHERE userName='" + user.getUserName() + "' and password = '"+user.getPassword()+"'";

        try {
            if (come.equals("signUp")) {
                user = queryRunner.query(sql1, new BeanHandler<User>(User.class));
            }
            if (come.equals("signIn")) {
                user = queryRunner.query(sql2, new BeanHandler<User>(User.class));
            }
            if (user != null) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    //添加用户
    public void addUser(User user) {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "INSERT INTO db_test.user(userName, password, email, birthday) VALUES (?,?,?,?)";
        try {
            queryRunner.update(sql,user.getUserName(),user.getPassword(),user.getEmail(),user.getBirthday());
            System.err.println("addUser语句执行完毕");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
