<%--
   1.首先是访问登录页面，填写用户名之后交给doLogin页面处理如果有用户名则并转发到list页面，
   如果没有用户名则回到login页面。

   2.然后也可以直接访问list页面，点击上面的页面跳转按钮跳转到想要去的页面，不过A页面不会被拦截，B页面与C页面会被拦截
   如果session中有登录信息则会通过拦截，没有则会转发到Login页面。
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Page</title>
</head>
<body>
<h4>AAA Page</h4>
<a href="a.jsp">To AAA Page</a>
<br><br>

<h4>BBB Page</h4>
<a href="b.jsp">To BBB Page</a>
<br><br>

<h4>CCC Page</h4>
<a href="c.jsp">To CCC Page</a>
<br><br>

<a href="out.jsp"> 登出</a>
</body>
</html>
