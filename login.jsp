<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<script type="text/javascript">
document.getElementById('loginForm').addEventListener('submit', function(event) {
    const username = document.getElementById('username').value.trim();
    const password = document.getElementById('password').value.trim();

    if (username === '' || password === '') {
        event.preventDefault();
        alert('Veuillez remplir tous les champs.');
    }
});

</script>
<body>
    <div class="login-container">
        <h1>Connexion</h1>
        <form action="login" method="post" id="loginForm">
            <label for="username">Nom d'utilisateur:</label>
            <input type="text" id="username" name="username">
            <label for="password">Mot de passe:</label>
            <input type="password" id="password" name="password">
            <input type="submit" value="Se connecter">
        </form>
        <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
    </div>
    <script src="script.js"></script>
</body>
</html>
