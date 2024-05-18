<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Services</title>
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/design.css"> <!-- Assurez-vous de corriger le chemin vers votre fichier CSS -->
</head>
<body>
    <%@ include file="header.jsp" %>

    <div class="container">
        <h1>Nos Services</h1>
        <div class="card">
                <img src="${service.imageService}" alt="${service.nomService}" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title">${service.nomService}</h5>
                    <p class="card-text">${service.description}</p>
                    <form action="demanderService" method="post">
                        <input type="hidden" name="serviceId" value="${service.idService}">
                        <button type="submit" class="custom-button">Demander Service</button>
                    </form>
                </div>
            </div>
        <c:forEach var="service" items="${services}">
            <div class="card">
                <img src="${service.imageService}" alt="${service.nomService}" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title">${service.nomService}</h5>
                    <p class="card-text">${service.description}</p>
                    <form action="demanderService" method="post">
                        <input type="hidden" name="serviceId" value="${service.idService}">
                        <button type="submit" class="custom-button">Demander Service</button>
                    </form>
                </div>
            </div>
        </c:forEach>
        
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
