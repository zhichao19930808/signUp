<%--
  Created by IntelliJ IDEA.
  User: Glory
  Date: 2017/8/10
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="SignUpServlet" method="post">
    用户名：<input type="text" name="userName" value="${requestScope.user.userName}">${requestScope.user.message.userName}<br>
    密码：<input type="password" name="password">${requestScope.user.message.password}<br>
    确认密码：<input type="password" name="repassword">${requestScope.user.message.repassword}<br>
    生日：<input type="text" name="birthday" value="${requestScope.user.birthday}">${requestScope.user.message.birthday}<br>
    Email：<input type="text" name="email" value="${requestScope.user.email}">${requestScope.user.message.email}<br>
    <input type="submit">
</form>
</body>
</html>
