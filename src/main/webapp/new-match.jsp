<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World123 test</title>
</head>
<body>
    <p>2 + 2 = <%= 2 + 2 %> test jsp</p>
    <p>5 > 2 = <%= 5 > 2 %></p>
    <p><%= new String("Hello").toUpperCase() %></p>
    <p>Today <%= new java.util.Date() %></p>
    <h1><%= "Hello World!" %></h1>
    <br/>
    <a href="main.jsp">Hello Servlet</a>
</body>
</html>