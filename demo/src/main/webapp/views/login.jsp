<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/register.css">
<body>


	<h2>Login</h2>
	<h3>${msg}</h3>
	<form:form action="checkLogInfo" method="POST" modelAttribute="user">
		<table>
			<tbody>

				<tr>
					<td>Enter Email :</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Enter password :</td>
					<td><form:password path="pass" /></td>
				</tr>

				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit" value="Login"/></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>