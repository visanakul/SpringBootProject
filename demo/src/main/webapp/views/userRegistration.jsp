<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/appstyle.css" >
<body>

	
	<h1>User Registration</h1>
	<h3>${msg}</h3>
	<form:form action="saveRegInfo" method="POST" modelAttribute="user">
		<table>
			<tbody>
				<tr>
					<td>Enter first name :</td>
					<td><form:input path="fname" /></td>
				</tr>
				<tr>
					<td>Enter last name :</td>
					<td><form:input path="lname" /></td>
				</tr>
				<tr>
					<td>Enter Email :</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Enter password :</td>
					<td><form:password path="pass" /></td>
				</tr>
				<tr>
					<td>Confirm password :</td>
					<td><form:password path="" /></td>
				</tr>
				<tr>
					<td>Enter mobile :</td>
					<td><form:input path="mobile" /></td>
				</tr>
				<tr>
					<td>Select gender :</td>
					<td><form:radiobuttons path="gen" items="${genders}" /></td>
				</tr>
				<tr>
					<td>Select Role :</td>
					<td><form:select path="role" items="${roles}"/></td>
				</tr>
				<tr style="display: flex block; background-color: aqua;">
					<td colspan="2"><input type="reset" value="Reset"
						style="float: left;" /><input type="submit" value="Register"
						style="float: right;" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>