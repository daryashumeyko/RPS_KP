
<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 26.04.2020
  Time: 20:11
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
        <td bgcolor="CC99FF" width="60"> <a href="../index">Выход</a></td>
        <td bgcolor="CC99FF" width="150"> <a href="../${backRef}">Вернуться назад</a> </td>
    </tr>
</table>
<br>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <td width="250" bgcolor="CC99FF"> <font size="5" color="660099">${cat}</font></td>
        <td><a href="36.html">Сортировать по рейтингу</a></td>
    </tr>

<c:choose>

    <c:when test="${fn:length(list) gt 0}">
        <c:forEach var="user" items="${list}">
            <tr>
                <td><a href="../organizatorInf/${user.userId}">${user.name} ${user.surname}</a></td>
                <td>фото</td>
                <td>${user.rating}</td>
            </tr>
        </c:forEach>
    </c:when>

    <c:otherwise>
    <tr>
        <td align="center"><h3>Список пуст</h3></td>
    </tr>
    </c:otherwise>
</c:choose>
</table>
</body>
</html>
