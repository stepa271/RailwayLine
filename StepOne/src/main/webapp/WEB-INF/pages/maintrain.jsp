<%--
  Created by IntelliJ IDEA.
  User: Stepa
  Date: 25.02.2022
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <th>| Number train |</th>
        <th>Id station</th>
        <th>| Count place |</th>
        <th> Action </th>
    </tr>


    <c:forEach var="i" begin="1" end ="4">
        <tr>
            <td> <p> Значение ${id} </p> </td>
            <td> <p> Значение ${i+10} </p> </td>
            <td> <p> Значение ${i+20} </p> </td>
            <td> <p> Значение ${i+30} </p> </td>
            <td>
                <a href="/edit/${train.id}">edit</a>
                <a href="/delete/${train.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
     <c:forEach var="temp" items="${trainsList}">
         <tr>
             <td>${trainsList.id} </td>
             <td>${temp.numbeTtrain}</td>
             <td>${temp.idStation}</td>
             <td>${temp.countPlace}</td>
             <td>
                 <a href="/edit/${temp.id}">edit</a>
                 <a href="/delete/${temp.id}">delete</a>
             </td>
         </tr>

    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add} >Add new train</a>
 <h3> <p>Today <%= new java.util.Date() %></p> </h3>


</body>
</html>
