<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 20.04.2020
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
    <style>
        TABLE{
            width: 50%;
            border-collapse: collapse;
            border: 2px solid white;
            align-self: center;
            margin: auto;
        }
        TD, TH {
            padding: 3px;
            border: 1px solid greenyellow;
            text-align: center;
        }
        a:link{text-decoration: none; color: green; font-size: 15px;  margin: auto;}
        a:hover{text-decoration: none; color: green; font-size: 20px;}
        a:visited{text-decoration: none; color: green}
        h3{color: green}
    </style>
</head>
<a href="index">Вернутся назад</a>
<center><h3>Список пользователей</h3></center>
<c:choose>
    <c:when test="${fn:length(list) gt 0}">
        <table border="2" width="70%" cellpadding="2">
            <tr><td>Id</td><td>nickname</td><td>пароль</td><td>email</td><td colspan="2">Действия</td></tr>
            <c:forEach var="user" items="${list}">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.login}</td>
                    <td>${user.password}</td>
                    <td>${user.email}</td>
                    <td><a href="show/${user.userId}">Изменить</a></td>
                    <td><a href="delete/${user.userId}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <center><h3>Список пуст, добавте пользователя</h3></center>
    </c:otherwise></c:choose>
</body>
</html>