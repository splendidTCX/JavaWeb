<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Page</title>
</head>
<body>
<%
    String username = request.getParameter("username");
%>

hello! <%=username%>

</body>
</html>
