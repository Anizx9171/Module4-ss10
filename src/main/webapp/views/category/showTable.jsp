<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27/11/2023
  Time: 11:32 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="category_manage">
    <input type="text" name="search">
    <button type="submit" name="action" value="search"> tìm </button>
    <button type="submit" name="action" value="sort"> a-z</button>
</form>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="cat">
        <tr>
            <td>${cat.categoryId}</td>
            <td>${cat.categoryName}</td>
            <td>${cat.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
