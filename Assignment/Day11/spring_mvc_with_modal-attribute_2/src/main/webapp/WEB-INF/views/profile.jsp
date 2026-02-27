
<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Profile</title>
</head>
<body>

<h2>Employee Profile</h2>

<p>First Name: ${emp.firstName}</p>
<p>Last Name: ${emp.lastName}</p>
<p>Gender: ${emp.gender}</p>
<p>Email: ${emp.email}</p>
<p>City: ${emp.city}</p>
<p>Country: ${emp.country}</p>
<p>Date of Birth: ${emp.dob}</p>
<p>Designation: ${emp.designation}</p>
<p>Pincode: ${emp.pincode}</p>

<a href="home">Go to Home</a>
</body>
</html>