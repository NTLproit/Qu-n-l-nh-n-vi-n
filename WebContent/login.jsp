<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css"
	media="all" />
</head>
<body>
	
	<div class="loginbox">
		<img src="image/avatar.png" class="avatar">
		<h1 class="titleLogin">Login</h1>
		<form action="doLogin" method="post">
			<p>Username</p>
			<input type="text" name="username" placeholder="Enter Username">
			<p>Password</p>
			<input type="password" name="password" placeholder="Enter Password">
			<input type="submit" value="Login"> <a href="#">Lost your
				password!</a>
				<br/>
			<p>
				<c:set var="message" value="${errLogin}"/>
				<c:if test="${message eq 'Login error'}">
					<c:out value="Username hoac Password sai!"></c:out>
				</c:if>
				<c:remove var="message"/>
			</p>
		</form>
	</div>
</body>
</html>