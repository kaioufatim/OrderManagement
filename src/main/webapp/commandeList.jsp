<%--
  Created by IntelliJ IDEA.
  User: AZUZ
  Date: 12/24/2023
  Time: 3:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Commande Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">

<%--        <ul class="navbar-nav">--%>
<%--            <li><a href="<%=request.getContextPath()%>/listCom"--%>
<%--                   class="nav-link">Commandes</a></li>--%>
<%--        </ul>--%>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Commandes</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/newCom" class="btn btn-success">Add
                New Commande</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Client ID </th>
                <th>Etat</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="commande" items="${listCommande}">

                <tr>
                    <td><c:out value="${commande.id}" /></td>
                    <td><c:out value="${commande.client.id}" /></td>
                    <td><c:out value="${commande.etat}" /></td>
<%--                    <td><a href="editC?id=<c:out value='${client.id}' />">Edit</a>--%>
<%--                        &nbsp;&nbsp;&nbsp;&nbsp; <a--%>
<%--                                href="deleteC?id=<c:out value='${client.id}' />">Delete</a></td>--%>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
</body>
</html>