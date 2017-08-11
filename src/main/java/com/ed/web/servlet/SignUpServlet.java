package com.ed.web.servlet;

import com.ed.domain.User;
import com.ed.domain.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("servlet...");
        //获取表单数据
        User user = new User();
        try {
            BeanUtils.populate(user,req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //验证表单信息是否符合注册的格式
        UserServiceImpl userService = new UserServiceImpl();
        if (userService.validate(user) && userService.quesyByName(user)) {
            System.out.println("符合");
            userService.signUp(user);
            resp.getWriter().print("注册成功，一秒后跳转到登录页面");
            resp.sendRedirect("signIn.jsp");
        } else {
            System.out.println("不符合");
            req.setAttribute("user",user);
            req.getRequestDispatcher("signUp.jsp").forward(req,resp);
        }
    }
}
