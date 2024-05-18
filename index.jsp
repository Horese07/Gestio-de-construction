<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <title>Page d'Accueil</title>
    <link rel="stylesheet" href="css/home.css">
      <link rel="stylesheet" href="css/design.css">
      <script src="js/Desgin.js"></script>
</head>
<body>
    <%@ include file="header.jsp" %>

    <div class="welcome-section">
        <h1>Bienvenue sur notre site de construction</h1>
        <p>Nous sommes ravis de vous accueillir sur notre site. Découvrez nos services et notre expertise.</p>
    </div>

    <div class="services-section">
        <h2>Nos Services</h2>
        <div class="services-container">
            <div class="service-card">
                <h3>Construction de Bâtiments</h3>
                <p>Nous réalisons des projets de construction de bâtiments résidentiels et commerciaux.</p>
                 <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Rénovation</h3>
                <p>Nos services de rénovation transforment votre espace selon vos besoins.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Ingénierie Structurelle</h3>
                <p>Nous offrons des solutions d'ingénierie structurelle robustes et fiables.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Planification Urbaine</h3>
                <p>Expertise en planification urbaine pour des développements durables.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Consultation en Construction</h3>
                <p>Conseils professionnels pour la gestion et la réalisation de vos projets.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Gestion de Projets</h3>
                <p>Gestion complète de projets de construction de toutes tailles.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Aménagement Paysager</h3>
                <p>Services d'aménagement paysager pour améliorer l'esthétique de vos espaces extérieurs.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Électricité et Plomberie</h3>
                <p>Installation et maintenance des systèmes électriques et de plomberie.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Construction Durable</h3>
                <p>Solutions de construction écologiques et durables pour l'avenir.</p>
                  <button class="btn-demand">Demander</button>
            </div>
        </div>
    </div>

    <div class="reviews-section">
        <h2>Avis</h2>
        <div class="reviews-container">
            <p>"Excellent service et très professionnel." - Client 1</p>
            <p>"Des projets livrés à temps et de haute qualité." - Client 2</p>
            <p>"Une équipe de confiance et compétente." - Client 3</p>
        </div>
    </div>

    <div class="about-section">
        <h2>Qui sommes-nous</h2>
        <p>Nous sommes une entreprise marocaine de construction avec des années d'expérience dans le secteur. Notre mission est de fournir des services de construction de haute qualité à nos clients.</p>
    </div>

    <%@ include file="footer.jsp" %>
    <script src="script.js"></script>
</body>
</html>
