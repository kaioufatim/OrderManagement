<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Commandes</title>
</head>
<body>

<h2>Liste des Commandes</h2>

<c:forEach var="commande" items="${commandes}">
    <!-- Afficher les détails de la commande ici -->
    <hr>
</c:forEach>

<!-- Formulaire d'ajout de commande -->
<form action="AjouterCommandeServlet" method="post">
    <!-- Champs pour le client, les articles commandés, et la date -->
    <label for="clientId">Client ID:</label>
    <input type="text" id="clientId" name="clientId" required>

    <!-- Ajoutez d'autres champs pour les articles et la date -->

    <input type="submit" value="Ajouter Commande">
</form>

</body>
</html>