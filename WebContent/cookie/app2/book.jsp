<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2016/12/28
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<h4>Book Detail Page</h4>
Book: <%=request.getParameter("book")%>

<br><br>
<a href="books.jsp">Return</a>
<%
    String bookName = request.getParameter("book");

    //1. 确定要被删除的 Cookie：
    //前提: ATGUIGU_BOOK_ 开头的 Cookie 数量大于或等于 5，

    Cookie[] cookies = request.getCookies();

    //保存所有的 ATGUIGU_BOOK_ 开头的 Cookie
    List<Cookie> bookCookies = new ArrayList<Cookie>();

    //用于存储到底是相同书名的或者是5个cookie中最旧的一个的变量
    Cookie tempCookie = null;

    if (cookies != null && cookies.length > 0) {
        for (Cookie c : bookCookies) {
            String cookieName = c.getName();
            if (cookieName.startsWith("ATGUIGU_BOOK_")) {
                bookCookies.add(c);
                if (c.getValue().equals(bookName)) {
                    tempCookie = c;
                }

            }
        }

    }
    //①. 且若从 books.jsp 页面传入的 book 不在 ATGUIGU_BOOK_ 的 Cookie 中则删除较早的那个 Cookie
    //（ ATGUIGU_BOOK_  数组的第一个 Cookie），

    if(bookCookies.size() >= 5 && tempCookie == null){
        tempCookie = bookCookies.get(0);
    }

    //setMaxAge=0表示删除此cookie
    if(tempCookie!=null){
        tempCookie.setMaxAge(0);
        response.addCookie(tempCookie);
    }

    //添加新点击书的cookie
    Cookie cookie=new Cookie("ATGUIGU_BOOK_"+bookName,bookName);
    response.addCookie(cookie);

%>

</body>
</html>
