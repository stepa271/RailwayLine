<%--
  Created by IntelliJ IDEA.
  User: Stepa
  Date: 25.02.2022
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Edit Page</title>
</head>
<body>

Edit page
</body>
</html>

--%>
<%-- v1.2
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<c:url value="/edit" var="var"/>
<br action="${var}" method="POST">
    <input type="hidden" name="id" value="${train.id}">

    <label for="numberTrain">Number Train</label>
    <input type="text" name="numberTrain" id="numberTrain">
    <label for="idStation">Id Station</label>
    <input type="text" name="idStation" id="idStation">
    <label for="countPlace">Count place</label>
    <input type="text" name="countPlace" id="countPlace">

    <input type="submit" value="Edit train">

</form>
</body>
</html>
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty train.title}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty train.title}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty train.title}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty train.title}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty train.title}">
        <input type="hidden" name="id" value="${train.id}">
    </c:if>
    <label for="numberTrain">Number Train</label>
    <input type="text" name="numberTrain" id="numberTrain">
    <label for="idStation">Id Station</label>
    <input type="text" name="idStation" id="idStation">
    <label for="countPlace">Count place</label>
    <input type="text" name="countPlace" id="countPlace">

    <c:if test="${empty train.title}">
        <input type="submit" value="Add new train">
    </c:if>
    <c:if test="${!empty train.title}">
        <input type="submit" value="Edit train">
    </c:if>
</form>
</body>
</html>

