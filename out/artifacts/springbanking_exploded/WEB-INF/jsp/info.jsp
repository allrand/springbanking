<%--
  Created by IntelliJ IDEA.
  User: toorxx
  Date: 2019-07-30
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="java.util.*" %>
<%
    String path = request.getContextPath();

    String basePath = path + "/";
%>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="<%=basePath%>weui/lib/weui.min.css">
    <link rel="stylesheet" href="<%=basePath%>weui/css/jquery-weui.css">
    <link rel="stylesheet" href="<%=basePath%>weui/css/pub-style.css">
    <script type="text/javascript" src="<%=basePath%>weui/lib/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="<%=basePath%>weui/js/jquery-weui.js"></script>
    <script type="text/javascript" src="<%=basePath%>weui/lib/fastclick.js"></script>
</head>
<body>
hi boy ${name}!

    <form id="form-edit">
        <div>
            <table border="1" cellpadding="4" cellspacing="0" width="100%">

                <tr>
                    <c:forEach items="${customers}" var="customer">
                        <div>
                            <div class="weui-form-preview__item">
                                <label class="weui-form-preview__label">用户名</label>
                                <span class="weui-form-preview__value">${customer.customerId}</span>
                            </div>
                        </div>
                    </c:forEach>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
