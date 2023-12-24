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
    <title>Article Management Application</title>
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
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Articles</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${article != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${article == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${article != null}">
                                Edit Article
                            </c:if>
                            <c:if test="${article == null}">
                                Add New Article
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${article != null}">
                        <input type="hidden" name="id" value="<c:out value='${article.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Article Name</label> <input type="text"
                                                           value="<c:out value='${article.name}' />" class="form-control"
                                                           name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Article Quantite</label> <input type="text"
                                                               value="<c:out value='${article.quantite}' />" class="form-control"
                                                               name="quantite">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Article Prix</label> <input type="text"
                                                           value="<c:out value='${article.prix}' />" class="form-control"
                                                           name="prix">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
