<%--


  app1目录下的jsp用Cookie模拟自动登陆，直接访问index.jsp页面，当Cookie中没有信息或超时则转到退回到登陆界面


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IndexPage</title>
</head>
<body>

<%
    //若可以获取到请求参数 name, 则打印出欢迎信息。把登录信息存储到 Cookie 中，并设置 Cookie 的最大时效为 30S
    String name = request.getParameter("name");
    if (name != null && !name.trim().equals("")) {
        Cookie cookie = new Cookie("name", name);
        cookie.setMaxAge(30);
        response.addCookie(cookie);
    } else {
        //从 Cookie 中读取用户信息，若存在则打印欢迎信息
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                String cookieName = c.getName();
                if ("name".equals(cookieName)) {
                    String val = c.getValue();
                    name = val;
                }
            }
        }
    }

    if (name != null && !name.trim().equals("")) {
        out.println("Hello: " + name);
    } else {
        response.sendRedirect("login.jsp");

    }

%>


</body>
</html>
