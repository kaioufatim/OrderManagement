<%--
  Created by IntelliJ IDEA.
  User: AZUZ
  Date: 12/24/2023
  Time: 8:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Client Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/listC"
                   class="nav-link">Clients</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Clients</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/Cnew" class="btn btn-success">Add
                New Client</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>First Name</th>
                <th>Adresse</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="client" items="${listClient}">

                <tr>
                    <td><c:out value="${client.id}" /></td>
                    <td><c:out value="${client.nom}" /></td>
                    <td><c:out value="${client.prenom}" /></td>
                    <td><c:out value="${client.adresse}" /></td>
                    <td><a href="editC?id=<c:out value='${client.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="deleteC?id=<c:out value='${client.id}' />">Delete</a></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
</body>
</html>