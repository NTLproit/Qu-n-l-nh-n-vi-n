<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" type="text/css" href="css/home.css" media="all">
<script src="js/home.js"></script>
</head>
<body>
	<img src="./image/header2.jpg" class="header">
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="${pageContext.request.contextPath}/doHome">Home</a>
		<a href="${pageContext.request.contextPath}/doManegement">Management</a>
		 <a href="${pageContext.request.contextPath}/doLogout">Logout</a>
	</div>
	<div id="main">
		<span class="nav" onclick="openNav()">&#9776; Home</span>
		<hr width="all" />
		<h1>Search employees</h1>
		<form action="doSearch" method="post">
			Name : <input type="text" name="searchName" class="txadd" /> <input
				type="submit" value="Search" id="btn1">
		</form>
	</div>
</body>
</html>