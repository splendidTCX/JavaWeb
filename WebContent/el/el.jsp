<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tcx.el.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL page</title>
</head>
<body>
<%--

1.EL表达式中有一个很重要的隐藏对象为pageContext,利用pageContext对象可以得到其他域对象。
2.EL表达式中调用的对象不断的调用属性的get方法。

--%>
<%
    List<String> names = new ArrayList<String>();
//    names.add("abc");
//    names.add("efg");
    request.setAttribute("names", names);

    Employee employee = new Employee();
    Employee employee1 = new Employee();
    employee.setName("Jerry");
    employee1.setName("Tom");
    request.setAttribute("employee", employee);
    request.getSession().setAttribute("employee", employee);
    request.getSession().setAttribute("com.atguigu.employee1", employee1);
%>
name:${sessionScope["employee"].name} &nbsp;&nbsp;
<!--
		如果域对象中的属性名带有特殊字符, 则使用 [] 运算符会很方便.
	-->
name: ${sessionScope["com.atguigu.employee1"].name }
<br><br>

List集合中的Name：${requestScope.names}
<br><br>

request域中Employee对象的name：${requestScope.employee.name}
<br><br>

请求链接param中的name：${param.name}
<br><br>

请求链接中多个name:${paramValues.name[0]} ${paramValues.name[1]}
<br><br>

JSESSIONID
${cookie.JSESSIONID.name} -- ${cookie.JSESSIONID.value}
<br><br>

${sessionScope.employee.name}
<br><br>

ContextPath:
${pageContext.request.contextPath}
<br><br>

sessionAttributeNames:
${pageContext.session.attributeNames}
<br><br>

sessionId
${pageContext.session.id}
<br><br>

EL的关系运算符
${param.score>60?'及格':'不及格'}
<br><br>

自动类型转换：
score: ${param.score + 11}
<br>
score: <%= request.getParameter("score") + 11 %>
<br><br>

<%--empty可以作用于一个集合，如果集合为null或者集合size为0，则empty为true--%>
IS EMPTY:
${requestScope.names} &nbsp;&nbsp;&nbsp;
${empty requestScope.names}
<br><br>
<a href="el2.jsp">To EL2 page </a>
</body>
</html>
