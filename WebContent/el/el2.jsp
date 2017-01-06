<%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2017/1/6
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL2 page</title>
</head>
<body>
${sessionScope.employee.name}
<%--pageContext 得到session 从而得到session中的对象：${pageContext.session.employee.name}--%>
<br><br>
</body>
</html>
