<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<title>User Home</title>
</head>
<body>

	<h1>Welcome to Mad Company</h1>

	<h2>Hello, ${emp.firstName}</h2>
	<p>Email: ${emp.email}</p>

	<br>
	<a href="index.jsp">Logout</a>
	<br>
</body>
</html>