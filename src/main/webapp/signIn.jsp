<%--
  Created by IntelliJ IDEA.
  User: Glory
  Date: 2017/8/11
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="SignInServlet" method="post">
    账号：<input type="text" name="userName"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
    <a href="signUp.jsp">注册</a>
</form>
${message}
</body>
</html>
