<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 26.04.2020
  Time: 18:48
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
                <td bgcolor="CC99FF" width="60"> <a href="index">Выход</a> </td>
                <td><a href="myInf">${userJSP.name} ${userJSP.surname}</a></td>
            </tr>
</table>
<br><br>
<table width="90%" border="1">
    <tr>
        <td width="250" bgcolor="CC99FF"> <font size="5" color="660099"><a href="33.html">Сообщения</a></font></td>
        <td><center><font color="000066" size="6">Свадебное агентство</font></center></td>
    </tr>
    <tr>
        <td width="250" bgcolor="CC99FF"> <font size="5" color="660099">Поиск</font></td>
        <td><center><font color="000066" size="6">"Мгновение"</font></center></td>
    </tr>
    <tr>
        <td><a href="weddingHosts/1">- Ведущие </a></td>
        <td rowspan="17">Мы являемся единственным свадебным агентством в городе Владимир,
            с помощью которого вы сможете подготовиться к одному из самых значимых дней в вашей жизни
            максимально быстро и просто. Вы сможете просмотреть анкеты ведущих, фотографов и других
            помощников в организации свадьбы, общаться с ними напрямую. Сможете подобрать шоу-программу
            и даже заказать торт.
        </td>
    </tr>
    <tr>
        <td> <a href="weddingHosts/2">- Фотографы </a></td>

    </tr>
    <tr><td> <a href="weddingHosts/3">- Видеографы </a></td></tr>
    <tr><td> <a href="weddingHosts/4">- Рестораны </a></td></tr>
    <tr><td> <a href="weddingHosts/5">- Декор и флористика </a></td></tr>
    <tr><td> <a href="weddingHosts/6">- Мастера причёски и макияжа </a></td></tr>
    <tr><td> <a href="weddingHosts/7">- Свадебные салоны </a></td></tr>
    <tr><td> <a href="weddingHosts/8">- Шоу-программы </a></td></tr>
    <tr><td> <a href="weddingHosts/9">- Транспорт </a></td></tr>
    <tr><td> <a href="weddingHosts/10">- Торты </a></td></tr>
    <tr><td> <a href="weddingHosts/11">- Музыкальное сопровождение </a></td></tr>
    <tr><td> <a href="weddingHosts/12">- Постановка свадебного танца </a></td></tr>
    <tr><td> <a href="weddingHosts/13">- Отели </a></td></tr>
    <tr>
        <td width="250" bgcolor="CC99FF"> <font size="5" color="660099">Моя свадьба</font></td>
    </tr>
    <tr><td> <a href="guests">- Список гостей </a></td></tr>
    <tr><td> <a href="18.html">- Учёт расходов </a></td></tr>
    <tr><td> <a href="19.html">- Мои заказы </a></td></tr>
</table>

</body>
</html>
