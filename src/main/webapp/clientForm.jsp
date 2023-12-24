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
<div class="container col-md-5">
  <div class="card">
    <div class="card-body">
      <c:if test="${client != null}">
      <form action="updateC" method="post">
        </c:if>
        <c:if test="${client == null}">
        <form action="insertC" method="post">
          </c:if>

          <caption>
            <h2>
              <c:if test="${client != null}">
                Edit Client
              </c:if>
              <c:if test="${client == null}">
                Add New Client
              </c:if>
            </h2>
          </caption>

          <c:if test="${client != null}">
            <input type="hidden" name="id" value="<c:out value='${client.id}' />" />
          </c:if>

          <fieldset class="form-group">
            <label>Client Name</label> <input type="text"
                                               value="<c:out value='${client.nom}' />" class="form-control"
                                               name="nom" required="required">
          </fieldset>

          <fieldset class="form-group">
            <label>Client First Name</label> <input type="text"
                                                   value="<c:out value='${client.prenom}' />" class="form-control"
                                                   name="prenom">
          </fieldset>

          <fieldset class="form-group">
            <label>Client Address</label> <input type="text"
                                               value="<c:out value='${client.adresse}' />" class="form-control"
                                               name="adresse">
          </fieldset>

          <button type="submit" class="btn btn-success">Save</button>
        </form>
    </div>
  </div>
</div>
</body>
</html>

