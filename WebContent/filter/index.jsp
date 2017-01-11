<%--
  用来测试filter的dispatcher属性
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Index Page</h4>
<a href="test.jsp"> To TestPage Normal</a>
<br><br>
<a href="dispatcher.jsp">To TestPage By dispatcher</a>
<br><br>
<a href="include.jsp">To TestPage By include</a>

<%--error page测试 error dispatcher测试--%>
<%
    int i = 10 / 0;%>

</body>
</html>
