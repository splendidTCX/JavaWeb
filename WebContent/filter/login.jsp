<%--
   Filter简单小例子
   1.输入name与password,然后分别用UserNameFilter与PassWordFilter去判断
   2.如果name不为Tom则跳转到登录页面，如果为password不为1234则跳转到登录页面
   3.如果name为Tom而且密码为1234，则跳转到hello.jsp页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<font color="red">${requestScope.message}</font>

<form action="hello.jsp" method="post">
    username:<input name="username" type="text"/>
    password:<input name="password" type="password"/>
    <input type="submit" value="Submit">
</form>

</body>
</html>
