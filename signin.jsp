<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Sign In</title>
     <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/design.css">
</head>
<body>
   <%@ include file="header.jsp" %>
    <h1>Create a New Account</h1>
    <form action="signin" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="telephone">Telephone:</label>
        <input type="text" id="telephone" name="telephone" required><br><br>
        <label for="adresse">Adresse :</label>
        <input type="text" id="adresse" name="adresse" required><br><br>
        <input type="submit" value="Sign In">
    </form>
       <%@ include file="footer.jsp" %>
</body>
</html>
