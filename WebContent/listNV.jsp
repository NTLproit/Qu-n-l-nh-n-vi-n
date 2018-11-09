<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/home.css" media="all">
<script src="js/home.js"></script>
</head>
<body>
	<img src="./image/header2.jpg" class="header">
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="${pageContext.request.contextPath}/doHome">Home</a> <a
			href="${pageContext.request.contextPath}/doManegement">Management</a>
		<a href="${pageContext.request.contextPath}/doLogout">Logout</a>a>
	</div>
	<div id="main">
		<span class="nav" onclick="openNav()">&#9776; Home</span>
		<hr width="all" />

		<table border="0" cellpadding="2" cellspacing="10">
			<tr>
				<td colspan="7"><c:set var="errDel" value="${errDelete}" /> <c:if
						test="${errDel eq 'User is maneger'}">
						<span class="validate"><c:out
								value="Khong the xoa maneger khac!" /></span>
					</c:if> <c:remove var="errDel" /></td>
			</tr>
			<tr>
				<td colspan="7" class="title">List Employees</td>
			</tr>
			<tr>
				<td class="title3">ID</td>
				<td class="title2">Name</td>
				<td class="title3">Age</td>
				<td class="title2">Address</td>
				<td class="title2">Position</td>
				<td class="title2">Description</td>
				<td class="title2">Select</td>
			</tr>
			<c:forEach items="${listNV}" var="list">
				<tr>
					<td class="title3"><c:out value="${list.getId()}"></c:out></td>
					<td class="title1"><c:out value="${list.getName()}"></c:out></td>
					<td class="title3"><c:out value="${list.getAge()}"></c:out></td>
					<td class="title2"><c:out value="${list.getAddress()}"></c:out>
					</td>
					<td class="title2"><c:out value="${list.getPosition()}"></c:out>
					</td>
					<td class="title2"><c:out value="${list.getDescription()}"></c:out>
					</td>
					<td class="title2"><a href="doEdit?id=${list.getId()}">Edit</a>
						<a href="doDelete?id=${list.getId()}"
						onclick="return confirm('Ban co muon xoa nhan vien khong?')">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>