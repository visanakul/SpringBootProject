function regFormValidate(){
	console.log('Hello');
	var validator=$('#regForm').validate({
		rules:{
			fname :"required",
			lname :"required",
			email :"required",
			pass :"required",
			gen :"required",
			mobile :"required",
			role:"required"
		},
		errorElement:"span",
		messages:{
			fname :"Enter First Name",
			lname :"Enter First Name",
			email :"Enter Last Name",
			pass :"Enter password",
			gen :"Select gender",
			mobile :"Enter mobile number",
			role:"Select role"
		}
	});
	if(validator.form()){
	${'#regForm').attr({
		action: "saveRegInfo"
	});
	${'form#regForm').submit();
	}
}