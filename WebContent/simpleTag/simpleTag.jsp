<%@ page import="com.tcx.simpleTag.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="mytag" uri="http://mytag.core.com/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  SimpleTag相关知识的案例
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SimpleTag</title>
</head>
<body>
<%
    List<Book> books = new ArrayList<Book>();
    Book book = new Book();
    Book book1 = new Book();

    book1.setName("Oracle");
    book.setName("Java");

    books.add(book);
    books.add(book1);

    request.setAttribute("books", books);

%>
<h4>将字母全部转换为大写</h4>
<mytag:UpperCase value="abcdefg"/>
<br><br>


<h4>ForEach</h4>
<mytag:foreach var="book" items="${requestScope.books}">
    ${book.name}-----
    <br>
</mytag:foreach>


<br><br>


<mytag:choose>

    <mytag:when test="${param.age>=35}">
        中年人
    </mytag:when>

    <mytag:when test="${param.age>=18}">
        青年人
    </mytag:when>

    <mytag:otherwise>
        未成年人

    </mytag:otherwise>
</mytag:choose>

<br><br>
${fn:length(param.name)}
<br><br>
测试自定义的EL自定义函数：<br>
${mytag:concat(param.name1,param.name2)}
</body>
</html>
