<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 30.04.2020
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title> Свадебное агентство </title>
</head>

<body bgcolor="FFCCFF">

<table border="3">
    <tr>
        <td bgcolor="CC99FF" width="60"> <a href="index">Выход</a></td>
        <td bgcolor="CC99FF" width="150"> <a href=${backRef}>Вернуться назад</a> </td>
    </tr>
</table>

<br>
<table border="2" width="70%" cellpadding="2">

    <tr>
        <td>${user.name} ${user.surname}</td>
        <td>Возраст: ${user.age}</td>
    </tr>
    <tr>
        <td>Телефон: ${user.telephone}</td>
        <td>Email: ${user.email}</td>
    </tr>
    <tr>
        <td>${user.weddingWishes}</td>
    </tr>
</table>

<table border="3">
    <tr>
        <td bgcolor="CC99FF" width="150"> <a href="editUser">Редактировать</a> </td>
    </tr>
</table>
</body>
</html>