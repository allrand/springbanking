<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: toorxx
  Date: 2019-08-07
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login to spring account banking</title>
</head>
<body>
<h1>Please enter you userid and password.</h1>
</p>
<form method="post">
    <spring:bind path="loginCommand">

    </spring:bind>

</form>
</body>
</html>
