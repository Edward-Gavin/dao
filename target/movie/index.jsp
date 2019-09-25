<%--
Created by IntelliJ IDEA.
User: edwardgavinwang
Date: 2019-09-23
Time: 21:39
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path=request.getContextPath();
    String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login form shake effect</title>
  <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="${basepath}/css/style.css">
</head>
<body>
<c:if test="${sessionScope.warn != null}">
    <h2 color="red" align="center"><c:out value="${sessionScope.warn}" /></h2>
</c:if>

<c:if test="${sessionScope.wareReg != null}">
    <h2 color="red" align="center"><c:out value="${sessionScope.wareReg}" /></h2>
</c:if>

    <form action='<c:url value="/doLogin" />' method="post">
          <div class="login-form" id="l">
             <h1>version1.0</h1>
              <div class="form-group ">
                <input type="text" class="form-control" placeholder="用户名" id="name">
                <i class="fa fa-user"></i>
              </div>

              <div class="form-group log-status">
                <input type="password" class="form-control" placeholder="密码" id="password">
                <i class="fa fa-lock"></i>
              </div>
               <div class="link-group">
                 <a class="link signup-link" style="margin-left: 2px; cursor: pointer;" href='<c:url value="/toReg" />'>注册</a>
                 <a class="link change-link" style="cursor: pointer">修改密码</a>
               </div>
              <button type="submit" class="log-btn" >登录</button>
           </div>
    </form>
    <form action='<c:url value="/doReg" />' method="post">
           <div class="signup-form" id="s">
            <i class="fa fa-arrow-left" style="cursor: pointer"></i>
             <div class="form-group ">
               <input type="text" class="form-control" placeholder="用户名" id="sUserName">
               <i class="fa fa-user"></i>
             </div>

             <div class="form-group sign-status1">
               <input type="password" class="form-control" placeholder="密码" id="sPassword">
               <i class="fa fa-lock"></i>
             </div>
             <div class="form-group sign-status2">
               <input type="password" class="form-control" placeholder="再次输入密码" id="srePassword">
               <i class="fa fa-lock"></i>
             </div>
             <button type="submit" class="sign-btn">注册</button>
          </div>
    </form>
    <form >
          <div class="change-form" id="c">
            <i class="fa fa-arrow-left" style="cursor: pointer"></i>
             <div class="form-group ">
               <input type="text" class="form-control" placeholder="用户名" id="cUserName">
               <i class="fa fa-user"></i>
             </div>

             <div class="form-group change-status1">
               <input type="password" class="form-control" placeholder="原密码" id="cPassword">
               <i class="fa fa-lock"></i>
             </div>
             <div class="form-group change-status2">
               <input type="password" class="form-control" placeholder="新密码" id="crePassword">
               <i class="fa fa-lock"></i>
             </div>
             <button type="submit" class="change-btn">提交</button>
          </div>
    </form>
  <script src='https://apps.bdimg.com/libs/jquery/2.1.3/jquery.min.js'></script>
    <script  src="${basepath}/js/index.js"></script>
</body>

</html>
