<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add employee</title>
<link rel="stylesheet" type="text/css" href="css/home.css" media="all">
<script src="js/home.js"></script>
</head>
<body>
	<img src="./image/header2.jpg" class="header">
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="${pageContext.request.contextPath}/doHome">Home</a> <a
			href="${pageContext.request.contextPath}/doManegement">Management</a>
		<a href="${pageContext.request.contextPath}/doLogout">Logout</a>
	</div>
	<div id="main">
		<span class="nav" onclick="openNav()">&#9776; Home</span>
		<hr width="all" />
		<h1>Add employees</h1>

		<form name="add" onsubmit="return validateAdd()" action="doAdd"
			method="post">
			<table border="0" cellspacing="5" cellpadding="3">
				<tr>
					<td class="td1">Name</td>
					<td><input type="text" name="addName" class="txadd" /> <span
						class="validate" id="name">
						</span>
						</td>
				</tr>
				<tr>
					<td class="td1">Age</td>
					<td><input type="text" name="addAge" class="txadd" /><span
						class="validate" id="numloc"></span></td>
				</tr>
				<tr>
					<td class="td1">Address</td>
					<td><input type="text" name="addAddress" class="txadd" /><span
						class="validate" id="address"></span></td>
				</tr>
				<tr>
					<td class="td1">Position</td>
					<td><input type="text" name="addPosition" class="txadd" /><span
						class="validate" id="position"></span></td>
				</tr>
				<tr>
					<td class="td1">Description</td>
					<td><input type="text" class="txadd" name="addDescription" /><span
						class="validate" id="description"></span></td>
				</tr>
				<tr>
					<td class="td1">Username</td>
					<td><input type="text" name="addUsername" class="txadd" /><span
						class="validate" id="username">
						<c:set var="message" value="${err}"/>
						<c:if test="${message eq 'username error' }">
							<c:out value="Usernam da ton tai trong database!"></c:out>
						</c:if>
						<c:remove var="message"/></span></td>
				</tr>
				<tr>
					<td class="td1">Password</td>
					<td><input type="password" name="addPassword" class="txadd" /><span
						class="validate" id="password"></span></td>
				</tr>
				<tr>
					<td class="td1">Type</td>
					<td><select class="sl1" name="addType">
							<option value="1">Admin</option>
							<option value="2">Nhan vien</option>
					</select></td>
				</tr>
				<tr></tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add" id="btn">
					</td>
				</tr>
			</table>
			<span class="validate">
				<c:set var="sucess" value="${sucess}"/>
				<c:if test="${sucess eq 'add sucess'}">
					<c:out value="Them thanh cong!"/>
				</c:if>
				<c:remove var="sucess"/>
			</span>
		</form>
	</div>
</body>
</html>