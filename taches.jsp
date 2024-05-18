<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="css/design.css">
</head>
<body>
    <%@ include file="header.jsp" %>

   <div class="cards-container">
    <c:forEach var="tache" items="${taches}">
        <div class="card-item">
            <div class="wrappers">
                <div class="banner-images" style="background-image: url();"></div>
                <h2 class="card-title">${tache.nomTache}</h2>
                <p class="card-text">Responsable: ${tache.nomRespo}</p>
                <p class="card-text"><strong>Date de Début:</strong> ${tache.dateDebut}</p>
                <p class="card-text"><strong>Date de Fin:</strong> ${tache.dateFin}</p>
                <p class="card-text"><strong>État d'Avancement:</strong> ${tache.etat}</p>
                <p class="card-text"><strong>Charge:</strong> ${tache.charge}</p>
                <p class="card-text"><strong>Remarque:</strong> ${tache.remarque}</p>
                <p class="card-text"><strong>Structure:</strong> ${tache.structure}</p>
            <div class="button-wrapper">
                    <form action="taches" method="post">
                        <input type="hidden" name="projetName" value="${projet.nom}">
                        <button type="submit" class="custom-button btn outline">Voir les details</button>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>

    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
