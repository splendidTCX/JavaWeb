<%@ page import="java.util.Date" %>
<%@ page import="com.tcx.token.TokenProcessor" %><%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2017/1/3
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<%

    // 这个是最基础的实现方式，我们这里借用struts1的TokenProcessor组件进行实现
   //  String tokenValue = new Date().getTime() + "";
    // session.setAttribute("token", tokenValue);

    String tokenValue = TokenProcessor.getInstance().saveToken(request);
%>
<form action="<%=request.getContextPath()%>/testServlet" method="post">
    <%--<input name="token" type="hidden" value="<%=tokenValue%>">--%>
    <input name="COM.ATGUIGU.TOKEN_KEY" type="hidden" value="<%=tokenValue%>">
    username:<input name="username" type="text">
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
