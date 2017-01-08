<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>doLogin Page</title>
</head>
<body>
<%
    String redirectPath = application.getInitParameter("redirectPage");
    String username = request.getParameter("name");
    //点击登录之后参数传递到这个页面，将username参数放入到session中，并将页面重定向到lis页面；
    //并如果没有填写username，则重定向到login.jsp页面。
    if (username != null && !username.trim().equals("")) {
        session.setAttribute(application.getInitParameter("userSessionKey"), username);
        //相对路径
        response.sendRedirect("list.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }
%>

</body>
</html>
