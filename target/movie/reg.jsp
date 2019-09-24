<%--
  Created by IntelliJ IDEA.
  User: edwardgavinwang
  Date: 2019-09-24
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="utf-8">
    <title>注册测试</title>
</head>
<body>
<table style="margin:20% auto;border:1px solid red;">
    <form action='<c:url value="/doReg" />' method="post">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name"></td>
        </tr>

        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>

        <tr>
            <td><input type="submit" value="注册"></td>
            <td><a style="text-decoration:none;border:1px solid red;background-color: aqua;color:red;" href='<c:url value="index" />'>前往登录</a></td>
        </tr>
    </form>
</table>
</body>
</html>