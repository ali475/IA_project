<!DOCTYPE html>
<html>
<head>
	<title>Register</title>

	<link href="css/register.css" rel="stylesheet">
	<link href="css/inputs.css" rel="stylesheet">
	<link href="css/header.css" rel="stylesheet">

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

<body class="body">

	<div class="header">
		<a href="#default" class="logo"><img class="logoImg" src="images/infinity.jpg"></a>
		<div class="header-right">
			<a class="active" href="#home">Home</a>
			<a href="#contact">Contact</a>
			<a href="#about">About</a>
		</div>
		<div class="most-right">
			<a class="submitButton" href="/index">login</a>
		</div>
	</div>

	<div class="register">
		<form name="registerForm" action="/register" method="POST">
			<input class="inputField" type="text" name="username" id="username" placeholder="user name" required="true">
			<br>
			<input class="inputField" type="email" name="email" id="email" placeholder="email" required="true" onchange="AJAX()">
			<div id="exist"></div>
			<input class="inputField" type="numbers" name="phone" id="phone" placeholder="phone number">
			<br>
			<input class="inputField" type="password" name="password" id="password" placeholder="password" required="true">
			<br>
			<div class="btn-container">
				<input class="submitButton" type="submit" value="Register" onclick="validate()">
			</div>
		</form>
	</div>
	
</body>
</html>