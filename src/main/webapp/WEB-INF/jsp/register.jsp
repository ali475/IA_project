<!DOCTYPE html>
<html>
<head>
	<title>Register</title>
	<script type="text/javascript">
		function validate()
		{
			if(!email(document.myForm.email))
			{
				alert("You have entered an invalid email address!");
				document.myForm.email.focus();
			}
			else if(!phone(document.myForm.phone))
			{
				alert("You have entered an invalid phone!");
				document.myForm.phone.focus();
			}

		}
		function email(inputText)
		{
			var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			if(inputText.value.match(mailformat))
				return true;
			else
				return false;
		}
		function phone(inputText)
		{
			var digitformat = /^\d+$/;
			if(inputText.value.match(digitformat))
				return true;
			else
				return false;
		}
	    function AJAX() 
	    {
            var xhttp;
            var name = document.getElementById("email").value;
            xhttp = new XMLHttpRequest();
            xhttp.open("GET", "testemail?email=" + email, true);
            xhttp.send();
            xhttp.onreadystatechange = function ()
            {
            	if (this.readyState == 4 && this.status == 200) 
                	document.getElementById("exist").innerHTML = this.responseText;
            };
        }
	</script>
</head>
<body>
	<form name="myForm" action="register" method="POST">
		User name:<input type="text" name="username" id="username" required="true"><br>
		Email:<input type="email" name="email" id="email" required="true" onchange="AJAX()"><div id="exist"></div>
		Phone number:<input type="numbers" name="phone" id="phone"><br>
		Password<input type="password" name="password" id="password" required="true"><br>
		<input type="submit" value="Register" onclick="validate()">
	</form>
	<a href="index">i have an account</a>
</body>
</html>