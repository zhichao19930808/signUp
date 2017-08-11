package com.ed.web.servlet;

import com.ed.dao.impl.UserDaoImpl;
import com.ed.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class SignInServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user,req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        UserDaoImpl userDao = new UserDaoImpl();
        if (userDao.findUser(user, "signIn")) {
            req.getSession().setAttribute("nick", user.getUserName());
            resp.sendRedirect("default.jsp");
            System.out.println(1);
        } else {
            req.setAttribute("message","账号或密码错误");
            req.getRequestDispatcher("signIn.jsp").forward(req,resp);
            System.out.println(2);
        }
    }
}
