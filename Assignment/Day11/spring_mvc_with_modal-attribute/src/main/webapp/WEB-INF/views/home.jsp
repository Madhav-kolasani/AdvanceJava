<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<title>User Home</title>
</head>
<body>

	<h1>Welcome to Mad Company</h1>

	<h2>Hello, ${user.username}</h2>
	<p>Email: ${user.email}</p>

	<br>
	<a href="login">Login</a>
	<br>
	<a href="register">Register</a>
</body>
</html>