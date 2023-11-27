<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27/11/2023
  Time: 3:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/student" method="post">
        <h1>Form Edit</h1>
        <div>
            <input type="hidden" name ="id" value="${id}">
            <p>Name:</p>
            <input type="text" name ="name">
            <p>Address:</p>
            <input type="text" name="address">
            <p>Birth Date:</p>
            <input type="date" name="date">
            <p>Email:</p>
            <input type="text" name="email">
            <button type="submit" name="action" value="edit">update</button>
        </div>
    </form>
</div>
</body>
</html>
