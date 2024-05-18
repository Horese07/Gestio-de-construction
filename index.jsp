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
        <p>Nous sommes ravis de vous accueillir sur notre site. D�couvrez nos services et notre expertise.</p>
    </div>

    <div class="services-section">
        <h2>Nos Services</h2>
        <div class="services-container">
            <div class="service-card">
                <h3>Construction de B�timents</h3>
                <p>Nous r�alisons des projets de construction de b�timents r�sidentiels et commerciaux.</p>
                 <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>R�novation</h3>
                <p>Nos services de r�novation transforment votre espace selon vos besoins.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Ing�nierie Structurelle</h3>
                <p>Nous offrons des solutions d'ing�nierie structurelle robustes et fiables.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Planification Urbaine</h3>
                <p>Expertise en planification urbaine pour des d�veloppements durables.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Consultation en Construction</h3>
                <p>Conseils professionnels pour la gestion et la r�alisation de vos projets.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Gestion de Projets</h3>
                <p>Gestion compl�te de projets de construction de toutes tailles.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Am�nagement Paysager</h3>
                <p>Services d'am�nagement paysager pour am�liorer l'esth�tique de vos espaces ext�rieurs.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>�lectricit� et Plomberie</h3>
                <p>Installation et maintenance des syst�mes �lectriques et de plomberie.</p>
                  <button class="btn-demand">Demander</button>
            </div>
            <div class="service-card">
                <h3>Construction Durable</h3>
                <p>Solutions de construction �cologiques et durables pour l'avenir.</p>
                  <button class="btn-demand">Demander</button>
            </div>
        </div>
    </div>

    <div class="reviews-section">
        <h2>Avis</h2>
        <div class="reviews-container">
            <p>"Excellent service et tr�s professionnel." - Client 1</p>
            <p>"Des projets livr�s � temps et de haute qualit�." - Client 2</p>
            <p>"Une �quipe de confiance et comp�tente." - Client 3</p>
        </div>
    </div>

    <div class="about-section">
        <h2>Qui sommes-nous</h2>
        <p>Nous sommes une entreprise marocaine de construction avec des ann�es d'exp�rience dans le secteur. Notre mission est de fournir des services de construction de haute qualit� � nos clients.</p>
    </div>

    <%@ include file="footer.jsp" %>
    <script src="script.js"></script>
</body>
</html>
