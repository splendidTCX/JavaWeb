<%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2017/1/6
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>checkCodePage</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/checkCodeServlet" method="post">
    name: <input type="text" name="name"/>
    checkCode: <input type="text" name="CHECK_CODE_PARAM_NAME"/>
    <img alt="" src="<%=request.getContextPath()%>/validateColorServlet">
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
