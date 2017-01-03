<%--
 模拟商城购物点击book返回并在books页显示点击的过的book,最多只能显示5个，并且点击相同的有记录book把旧的记录删除，新的记录添加到末尾。
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h4>Books Page</h4>
<a href="book.jsp?book=JavaWeb">Java Web</a><br><br>
<a href="book.jsp?book=Java">Java</a><br><br>
<a href="book.jsp?book=Oracle">Oracle</a><br><br>
<a href="book.jsp?book=Ajax">Ajax</a><br><br>
<a href="book.jsp?book=JavaScript">JavaScript</a><br><br>
<a href="book.jsp?book=Android">Android</a><br><br>
<a href="book.jsp?book=Jbpm">Jbpm</a><br><br>
<a href="book.jsp?book=Struts">Struts</a><br><br>
<a href="book.jsp?book=Hibernate">Hibernate</a><br><br>
<a href="book.jsp?book=Spring">Spring</a><br><br>

<br><br>
<%
 Cookie[] cookies=request.getCookies();
    if(cookies!=null&&cookies.length>0){
        for(Cookie cookie:cookies){
            if(cookie.getName().startsWith("ATGUIGU_BOOK_")){
                out.print(cookie.getValue()+"  ");

            }
        }
    }

%>


</body>
</html>
