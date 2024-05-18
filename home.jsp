<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="css/design.css">
</head>
    <meta charset="ISO-8859-1">
    <title>Home</title>
    <style>
        .card {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 16px;
            margin: 16px;
            width: 300px;
            display: inline-block;
            vertical-align: top;
        }
        .card h3 {
            margin-top: 0;
        }
    </style>
</head>
<body >
<%@ include file="header.jsp" %>
<h1>Vos Projects</h1>
<div class="cards-container">
    <c:forEach var="projet" items="${projets}">
        <div class="card-item">
            <div class="wrappers">
                <div class="banner-images" style="background-image: url(${projet.image});"></div>
                <h1>${projet.nom}</h1>
                <p><strong>Adresse:</strong> ${projet.adresse}</p>
                <p><strong>Chef de Projet:</strong> ${projet.chefProjet}</p>
                <p><strong>Start Date:</strong> ${projet.dateDebut}</p>
                <p><strong>End Date:</strong> ${projet.dateFin}</p>
                <p><strong>Budget:</strong> ${projet.budget}</p>
                <p><strong>Type:</strong> ${projet.type}</p>
                <p><strong>Tâches:</strong> ${projet.taches}</p>
                <p><strong>État d'Avancement:</strong> ${projet.etat}%</p>
                <div class="button-wrapper">
                    <form action="taches" method="post">
                        <input type="hidden" name="projetName" value="${projet.nom}">
                        <button type="submit" class="custom-button btn outline">Voir les tâches</button>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
</div>


<%@ include file="footer.jsp" %>
<c:if test="${empty projets}">
    <p>No projects available.</p>
</c:if>
</body>
</html>
