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
<%--                   class="nav-link">commandes</a></li>--%>
<%--        </ul>--%>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${commande != null}">
            <form action="updateCom" method="post">
                </c:if>
                <c:if test="${commende == null}">
                <form action="insertCom" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${commande != null}">
                                Edit Commande
                            </c:if>
                            <c:if test="${commande == null}">
                                Add New Commande
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${commande != null}">
                        <input type="hidden" name="id" value="<c:out value='${commande.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Client ID</label> <input type="number"
                                                          value="<c:out value='${commande.client.id}' />" class="form-control"
                                                          name="clientId" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Etat</label> <input type="text"
                                                                value="<c:out value='${commande.etat}' />" class="form-control"
                                                                name="etat">
                    </fieldset>


                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>

