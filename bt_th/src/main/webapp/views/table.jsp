<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27/11/2023
  Time: 3:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* Apply some basic styles to the table */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        /* Style the table header */
        thead {
            background-color: #f2f2f2;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        /* Style alternate rows for better readability */
        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        /* Style the "Edit" and "Delete" links */
        a {
            display: inline-block;
            padding: 5px 10px;
            text-decoration: none;
            color: #333;
            border: 1px solid #ddd;
            border-radius: 3px;
            margin-right: 5px;
        }

        a:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<a href="/student?action=add">add</a>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Address</th>
        <th>BirthDate</th>
        <th>Email</th>
        <th colspan="2"></th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${students}" var="stu">
    <tr>
        <td>${stu.studentId}</td>
        <td>${stu.studentName}</td>
        <td>${stu.studentAddress}</td>
        <td>${stu.studentBirthdate}</td>
        <td>${stu.studentEmail}</td>
        <td><a  href="/student?action=edit&id=${stu.studentId}">Edit</a></td>
        <td><a onclick="return confirm('Bạn muốn xóa ${stu.studentName}?')" href="/student?action=delete&id=${stu.studentId}">Delete</a></td>
    </tr>
</c:forEach>
    </tbody>
</table>
</body>
</html>
