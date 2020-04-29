<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 26.04.2020
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Свадебное агентство </title>
</head>

<body bgcolor="FFCCFF">

<table border="3">
    <tr>
        <td bgcolor="CC99FF" width="60"> <a href="index">Выход</a></td>
        <td bgcolor="CC99FF" width="150"> <a href="userIndex">Вернуться назад</a> </td>
    </tr>
</table>
<br>

<c:choose>
    <c:when test="${fn:length(list) gt 0}">
        <table border="2" width="70%" cellpadding="2">
            <tr>
                <td width="250" bgcolor="CC99FF"> <font size="5" color="660099">${cat}$</font></td>
                <td><a href="36.html">Сортировать по рейтингу</a></td>
            </tr>

            <c:forEach var="user" items="${list}">
                <tr>
                    <td>${user.name}  ${user.surname}</td>
                    <td>фото</td>
                    <td>${user.rating}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <center><h3>Список пуст</h3></center>
    </c:otherwise>
</c:choose>
</body>
</html>
