<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/login_register.css">
<body style="padding-top: 50px;">


	<h2>Login</h2>
	<h3>${msg}</h3>
	<form:form id="logForm" name="logForm" action="checkLogInfo" method="POST" modelAttribute="login">
		<table>
			<tbody>

				<tr>
					<td>Enter Email :</td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Enter password :</td>
					<td><form:password path="pass" /></td>
					<td><form:errors path="pass" cssClass="error" /></td>
				</tr>

				<tr>
					<td colspan="2" style="text-align: center;"><input type="submit"
						value="Login" onclick="logFormValidate();"/></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/login_validation.js"></script>
</body>
</html>