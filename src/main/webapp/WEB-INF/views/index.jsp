<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome to Spring Boot War Demo</h1>

	<p>
		Connection successful to DB: <b>${jdbcUrl}</b><br>using user: <b>${dbUser}</b>
	</p>
</body>
</html>