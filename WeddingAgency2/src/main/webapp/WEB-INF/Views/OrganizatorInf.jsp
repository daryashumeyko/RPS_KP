<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 29.04.2020
  Time: 10:12
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
        <td bgcolor="CC99FF" width="150"> <a href="../${backRef}">Вернуться на главную страницу</a> </td>
    </tr>
</table>
<br>
<table border="2" width="70%" cellpadding="2">

    <tr>
        <td>Ведущий: ${user.name} ${user.surname}</td>
        <td>Рейтинг: ${user.rating}</td>
    </tr>
    <tr>
        <td>${user.description}</td>
        <td>фото</td>
    </tr>
    <tr>
        <td>Телефон: ${user.telephone}</td>
        <td>Email: ${user.email}</td>
    </tr>
    <tr>
        <td>${user.organizationName}</td>
        <td>${user.address}</td>
    </tr>
</table>
<br>
<table border="0">
    <tr>
        <td bgcolor="CC99FF" width="150"> <a href="23.html">Добавить отзыв</a> </td>
    </tr>
    <tr>
        <td>
            <select>
                <option label="1" value="1" selected>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </td>
    </tr>
    <tr>
        <td bgcolor="CC99FF" width="150"> <a href="23.html">Поставить оценку</a> </td>
    </tr>
    <tr>
        <input type="text" size="100">
    </tr>
    <tr>
        <td bgcolor="CC99FF" width="150"> <a href="34.html">Написать сообщение</a> </td>
    </tr>
</table>

</body>
</html>





