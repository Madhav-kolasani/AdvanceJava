<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>

	<h2>Login Page</h2>

	<form action="login-submit" method="post">

		UserName: <input type="text" name="firstName" /><br> <br>
		Password: <input type="password" name="password" /><br> <br>
		<input type="submit" value="Login" /> <input type="reset"
			value="Cancel" />

	</form>
</body>
</html>