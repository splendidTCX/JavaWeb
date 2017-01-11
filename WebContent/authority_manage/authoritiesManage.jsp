<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2017/1/9
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorities Manage</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/authorityManageServlet?method=getAuthorities" method="post">
    username:<input type="text" name="username"/>
    <input type="submit" value="search">
</form>

<c:if test="${requestScope.user!=null}">
    用户：${requestScope.user.username}&nbsp;权限如下：
    <form action="<%=request.getContextPath()%>/authorityManageServlet?method=updateAuthorities" method="post">
            <%--隐藏域中存放的是username--%>
        <input type="hidden" name="username" value="${requestScope.user.username}">
        <c:forEach items="${requestScope.authorities}" var="auth">
            <c:set var="flag" value="false"/>

            <c:forEach items="${requestScope.user.authorities}" var="ua">
                <c:if test="${ua.url==auth.url}">
                    <c:set var="flag" value="true"/>
                </c:if>
            </c:forEach>

            <c:if test="${flag==true}">
                ${auth.displayName} :<input type="checkbox" name="url" value="${auth.url}" checked><br>
            </c:if>

            <c:if test="${flag==false}">
                ${auth.displayName}：<input type="checkbox" name="url" value="${auth.url}"><br>
            </c:if>


        </c:forEach>
        <input type="submit" value="Update">
    </form>

</c:if>
</body>
</html>
