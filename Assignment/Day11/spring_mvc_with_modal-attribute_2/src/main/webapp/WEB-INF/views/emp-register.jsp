<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<title>Employee Registration</title>
</head>
<body>

	<h2>Employee Registration Form</h2>

	<form action="reg-submit" method="post">

		First Name: <input type="text" name="firstName" /><br>
		<br> Last Name: <input type="text" name="lastName" /><br>
		<br> Gender: <input type="radio" name="gender" value="Male" /> Male 
		<input type="radio" name="gender" value="Female" /> Female <br>
		<br> Email: <input type="email" name="email" /><br>
		<br> City: <input type="text" name="city" /><br>
		<br> Country: <input type="text" name="country" /><br>
		<br> Date of Birth: <input type="date" name="dob" /><br>
		<br> Designation: <input type="text" name="designation" /><br>
		<br> Pincode: <input type="number" name="pincode" /><br>
		<br> <input type="submit" value="Submit" />

	</form>

</body>
</html>