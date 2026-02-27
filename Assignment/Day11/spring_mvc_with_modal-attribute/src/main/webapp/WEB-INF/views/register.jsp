<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
<title>Register</title>
</head>
<body>

	<h2>Register Page</h2>

	<form action="reg-submit" method="post">

		UserName: <input type="text" name="username" /><br> <br>
		Email: <input type="email" name="email" /><br> <br>
		City: <input type="text" name="city" /><br> <br>
		Password: <input type="password" name="password" /><br> <br>
		Confirm Password: <input type="password" name="confirmPassword" /><br>
		
		<br> <input type="submit" value="Register" /> <input
			type="reset" value="Cancel" />

	</form>

</body>
</html>