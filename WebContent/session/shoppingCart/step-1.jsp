<%--
  session实现简易购物车
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Step-1 Page</title>
</head>
<body>

<h4>Step1: 选择要购买的图书:</h4>

<form action="<%=request.getContextPath()%>/step1Servlet" method="post">
    <table border="1" cellpadding="10" cellspacing="0">

        <tr>
            <td>书名</td>
            <td>购买</td>
        </tr>

        <tr>
            <td>Java</td>
            <td><input type="checkbox" name="book" value="Java"/></td>
        </tr>

        <tr>
            <td>Oracle</td>
            <td><input type="checkbox" name="book" value="Oracle"/></td>
        </tr>

        <tr>
            <td>Struts</td>
            <td><input type="checkbox" name="book" value="Struts"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>

    </table>
</form>

</body>
</html>
