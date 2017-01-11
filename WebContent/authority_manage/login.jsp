<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/loginServlet?method=login" method="post">
    username:<input name="name" type="text">
    <input type="submit" value="Submit">
</form>

</body>
</html>
