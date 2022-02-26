<%--
  Created by IntelliJ IDEA.
  User: Stepa
  Date: 25.02.2022
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
подключается JSTL core, которая включает основные теги создания циклов, условий и т.д.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TRAINS</title>
</head>
<body>

<h2>Trains</h2>
<table>
    <tr>
        <th>id</th>
        <th>| number train |</th>
        <th>id station</th>
        <th>| count place |</th>
        <th>action</th>
    </tr>
    <c:forEach var="train" items="${trainsList}">
        <tr>
            <td>${train.id}</td>
            <td>${train.numbertrain}</td>
            <td>${train.idstation}</td>
            <td>${train.countplace}</td>
            <td>
                <-- мы сделали ссылки для каждого фильма с указанием id -->
                <a href="/edit/${train.id}">edit</a>
                <a href="/delete/${train.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add} >Add new train</a>



</body>
</html>
