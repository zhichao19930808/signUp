<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Glory
  Date: 2017/8/9
  Time: 8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      *{
        padding: 0;
        margin: 0;
      }
      th {
        width: 150px;
        height: 50px;
        text-align: center;
      }
      td {
        width: 150px;
        height: 30px;
        text-align: center;
      }
      table {
        margin: auto;
      }
    </style>
  </head>
  <body>
  <%
    List<String> list = new ArrayList<String>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");
    request.setAttribute("list",list);
  %>
  <table border="1" cellpadding="0">
    <tr>
      <th>数据</th>
      <th>索引</th>
      <th>计数</th>
      <th>first</th>
      <th>last</th>
    </tr>
    <c:forEach items="${list}" var="list" varStatus="vs">
      <tr ${vs.count%2==1?"style=background-color:lime":"style=background-color:yellow"}>
        <td>${list}</td>
        <td>${vs.index}</td>
        <td>${vs.count}</td>
        <td>${vs.first}</td>
        <td>${vs.last}</td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
