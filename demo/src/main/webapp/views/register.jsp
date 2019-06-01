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
<link rel="stylesheet" href="css/mydatepicker.css">

<body>


	<h2>Registration</h2>
	<h3>${msg}</h3>
	<form:form id="regForm" name="regForm" action="saveRegInfo"
		method="post" modelAttribute="user">
		<table>
			<tbody>
				<tr>
					<td>Enter first name :</td>
					<td><form:input path="fname" name="fname" /></td>
					<td><form:errors path="fname" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Enter last name :</td>
					<td><form:input path="lname" name="lname" /></td>
					<td><form:errors path="lname" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Enter Email :</td>
					<td><form:input path="email" name="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Enter password :</td>
					<td><form:password path="pass" id="pass" name="pass" /></td>
					<td><form:errors path="pass" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Confirm password :</td>
					<td><form:password path="cpass" name="cpass" /></td>
					<td><form:errors path="cpass" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Enter mobile :</td>
					<td><form:input path="mobile" name="mobile" /></td>
					<td><form:errors path="mobile" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Select gender :</td>
					<td class="gen"><form:radiobuttons path="gen" items="${genders}"
							name="gen" /></td>
					<td><form:errors path="gen" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Select Role :</td>
					<td><form:select path="role" items="${roles}" name="role" /></td>
				</tr>
				<tr>
					<td>Select DOB :</td>
					<td><form:input path="dob" id="datepicker" /></td>
					<td><form:errors path="dob" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="btn-container">
							<input type="reset" value="Reset" style="float: left;" /><input
								type="submit" value="Register" style="float: right;"
								onclick="regFormValidate();" />
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
		 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript" src="js/register_validation.js"></script>
	
</body>
</html>