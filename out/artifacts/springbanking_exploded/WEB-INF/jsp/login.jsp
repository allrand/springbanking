<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: toorxx
  Date: 2019-08-07
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>Login to spring account banking</title>
</head>
<body>
<h1>Please enter you userid and password.</h1>
</p>

<div class="header"><h1 style="text-align: center;color: #515151;">管理平台</h1></div>
<div class="loginWraper img_size">
    <div id="loginform" class="loginBox">
        <form class="form form-horizontal" action="<%=basePath%>login" method="post">
            <%--<form class="form form-horizontal" action="<%=basePath%>loginByAuth.html" method="post">--%>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-xs-8">
                    <input id="username" name="username" type="text" value="" placeholder="用户名" class="input-text size-L" required="required">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-xs-8">
                    <input id="password" name="password" type="password" value="" placeholder="密码" class="input-text size-L" required="required">
                </div>
            </div>

            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <input type="submit" class="btn btn-success radius size-L" value="登录">
                </div>
            </div>
            <c:if test="${empty retMsg ?false:true }">
                <div class="row cl">
                    <div class="formControls col-xs-8 col-xs-offset-3">
                        <span style="color:red">${retMsg }</span>
                    </div>
                </div>
            </c:if>
        </form>
    </div>
</div>
<div class="footer">Copyright xkxx</div>
</body>
</html>
