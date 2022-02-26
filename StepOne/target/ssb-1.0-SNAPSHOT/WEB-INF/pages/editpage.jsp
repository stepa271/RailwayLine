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


