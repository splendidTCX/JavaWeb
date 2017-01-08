<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tcx.el.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2017/1/7
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL Page</title>
</head>
<body>
<%
    List<Employee> employees = new ArrayList<Employee>();
    employees.add(new Employee("Tom", 22));
    employees.add(new Employee("Jerry", 21));
    employees.add(new Employee("Herry", 20));
    request.setAttribute("employees", employees);


    Map<String, Employee> employeeMap = new HashMap<String, Employee>();
    employeeMap.put("a", new Employee("Tom", 22));
    employeeMap.put("b", new Employee("Jerry", 21));
    employeeMap.put("c", new Employee("Mike", 23));
    employeeMap.put("d", new Employee("Hanks", 22));
    request.setAttribute("employeeMap", employeeMap);


    String[] names = new String[]{"A", "B", "C"};
    request.setAttribute("names", names);

%>

foreach可以对数组，Collection,Map进行遍历
<br><br>

collection的遍历
<br>
<c:forEach var="employee" items="${requestScope.employees}">
    ${employee.name}----${employee.age}
    <br>
</c:forEach>
<br><br>

map的遍历
<br>
<c:forEach var="employee" items="${requestScope.employeeMap}">
    ${employee.key}----${employee.value.name}----${employee.value.age}
    <br>
</c:forEach>

<br><br>
数组的遍历
<c:forEach items="${requestScope.names}" var="name">
    ${name}
    <br>
</c:forEach>
<%
    request.getSession().setAttribute("hello", "hello");
%>
<br><br>
${pageContext.session.getAttribute("hello")}
${pageContext.session.id}
<br><br>
${sessionScope.hello}

<br><br>
</body>
</html>
