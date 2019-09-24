<%--
  Created by IntelliJ IDEA.
  User: edwardgavinwang
  Date: 2019-09-24
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="utf-8">
    <title>成功登录后台系统</title>
    <style>
        td{
            border: 1px solid red;
        }
    </style>
</head>
<body>
<c:if test="${sessionScope.user != null}">
    <table style="margin:20% auto;border:1px solid red;">
        <caption>欢迎用户<c:out value="${sessionScope.user.name}" /></caption>
        <tr>
            <td>用户名</td>
            <td><c:out value="${sessionScope.user.name}" /></td>
        </tr>

        <tr>
            <td>密码</td>
            <td><c:out value="${sessionScope.user.password}" /></td>
        </tr>

        <tr border="1px">
            <td>注册时间</td>
            <td><c:out value="${sessionScope.user.regtime}" /></td>
        </tr>
        <tr>
            <td><a href='<c:url value="/doLogout" />'>退出登录</a></td>
        </tr>
    </table>
</c:if>
<c:if test="${sessionScope.user == null}">
    <h1 align="center" color="red">你尚未登录，点击<a href='<c:url value="/index" />'>此处</a>进行登录!</h1>
</c:if>
</body>
</html>
