<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 30.04.2020
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать</title>
</head>
<body>
<a href="index">Вернуться назад</a>
<center><h3>Измените данные о пользователе</h3></center>
<form:form method="post" action="editsave">
    <table>
        <form:hidden path="userId"/>
        <tr><td>nickname</td>
            <td><form:input  path="login"/></td>
        </tr>
        <tr>
            <td>пароль</td>
            <td><form:input path="password"  /></td>
        </tr>
        <tr>
            <td>email</td>
            <td><form:input path="email"  /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Принять изменения" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>