<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 20.04.2020
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Добавление</title>
    <style>
        TABLE{
            width: 50%;
            border-collapse: collapse;
            border: 2px solid white;
            margin: auto;
        }
        TD, TH {
            padding: 3px;
            border: 1px solid greenyellow;
            text-align: center;
        }
        input{background: greenyellow}
        a:link{text-decoration: none; color: green; font-size: 15px;  margin: auto;}
        a:hover{text-decoration: none; color: green; font-size: 20px;}
        a:visited{text-decoration: none; color: green}
        h3{color: green}
    </style>
</head>
<body>
<a href="index">Вернутся назад</a>
<center><h3>Введите данные о пользователе</h3></center>
<form:form method="post" action="saveuser">
    <table >
        <tr>
            <td>NickName</td>
            <td><form:input path="login"  /></td>
        </tr>
        <tr>
            <td>пароль</td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td>email</td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Добавить" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>