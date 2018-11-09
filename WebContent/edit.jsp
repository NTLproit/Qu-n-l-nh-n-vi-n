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
		<a href="${pageContext.request.contextPath}/doHome">Home</a>
		<a href="${pageContext.request.contextPath}/doManegement">Management</a>
		 <a href="${pageContext.request.contextPath}/doLogout">Logout</a>
	</div>
	<div id="main">
		<span class="nav" onclick="openNav()">&#9776; Home</span>
		<hr width="all" />
		<h1>Edit employees</h1>
		<c:set value="${nvedit}" var="nvEdit"></c:set>
		
		<form name="edit" onsubmit="return validateEdit()" action="doEdit?id=${nvEdit.getId()}" method="post">
			<table border="0" cellspacing="5" cellpadding="3">
				<tr>
					<td class="td1">Name</td>
					<td><input type="text" name="editName" class="txadd"
						value="${nvEdit.getName()}" /><span class="validate" id="name1"></span></td>
				</tr>
				<tr>
					<td class="td1">Age</td>
					<td><input type="text" name="editAge" class="txadd"
						value="${nvEdit.getAge()}" /><span id="numloc1"></span></td>
				</tr>
				<tr>
					<td class="td1">Address</td>
					<td><input type="text" name="editAddress" class="txadd"
						value="${nvEdit.getAddress()}" /><span class="validate" id="address1"></span></td>
				</tr>
				<tr>
					<td class="td1">Position</td>
					<td><input type="text" name="editPosition" class="txadd"
						value="${nvEdit.getPosition()}" /><span class="validate" id="position1"></span></td>
				</tr>
				<tr>
					<td class="td1">Description</td>
					<td><input type="text" class="txadd" name="editDescription" value="${nvEdit.getDescription()}"/><span class="validate" id="description1"></span></td>
				</tr>
				<tr>
					<td class="td1">Username</td>
					<td><input type="text" name="editUsername" class="txadd"
						value="${nvEdit.getUsername()}" /><span class="validate" id="username1"></span></td>
				</tr>
				<tr>
					<td class="td1">Password</td>
					<td><input type="password" name="editPassword" class="txadd"
						value="${nvEdit.getPassword()}" /><span class="validate" id="password1"></span></td>
				</tr>
				<tr>
					<td class="td1">Type</td>
					<td><select class="sl1" name="editType">
							<c:choose>
								<c:when test="${nvEdit.getType() eq 1}">
									<option value="1">Admin</option>
									<option value="2">Nhan vien</option>
								</c:when>
								<c:otherwise>
									<option value="2">Nhan vien</option>
									<option value="1">Admin</option>
								</c:otherwise>
							</c:choose>
					</select></td>
				</tr>
				<tr></tr>
				<tr>
					<td colspan="2"><input type="submit" value="Edit" id="btn">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>