<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 26.04.2020
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title> Свадебное агентство </title>
</head>

<body bgcolor="FFCCFF">
<form:form method="post" action="saveuser">
    <table >
        <tr>
            <td>Логин:</td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
    </table>
</form:form>

<table border="2">
    <tr>
        <td bgcolor="CC99FF" width="100"> <a href="userIndex">Войти</a> </td>
        <td bgcolor="CC99FF" width="120"> <a href="index">Вернуться назад</a> </td>
    </tr>
</table>

</body>
</html>
