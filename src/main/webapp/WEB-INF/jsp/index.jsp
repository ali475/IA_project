<!DOCTYPE html>
<html>
<head>
	<title>Login</title>

	<link href="css/index.css" rel="stylesheet">
	<link href="css/inputs.css" rel="stylesheet">

	<script type="text/javascript">
		function validate(inputText)
		{
			var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			if(inputText.value.match(mailformat))
				return true;
			else
			{
				alert("You have entered an invalid email address!");
				document.myForm.email.focus();
				return false;
			}
		}
		function AJAXmail() 
	    {
            var xhttp;
            var email = document.getElementById("email").value;
            var type = document.getElementById("type").value;
            xhttp = new XMLHttpRequest();
            xhttp.open("GET", "testemail?email="+ email+"&type="+ type, true);
            xhttp.send();
            xhttp.onreadystatechange = function ()
            {
            	if (this.readyState == 4 && this.status == 200) 
                	document.getElementById("exist").innerHTML = this.responseText;
        };} 

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
	</div>

	<div class="login">
		<form name="loginForm" action="login" method="GET">
			<input class="inputField" type="email" name="email" id="email" required="true" placeholder="Email" onchange="AJAXmail()">
			<p class="msg" id="exist"></p><br>
			<input class="inputField" type="password" name="password" id="password" required="true" placeholder="password"><br>
			<div class="userType">
				<input class="radio" type="radio" name="type" id="type" value="a" checked> <label for="type">Applicant</label>
				<input class="radio" type="radio" name="type" id="type"  value="h"> <label for="type">HR</label>
			</div>
			<div class="btn-container"><input id="submitButton" type="submit" value="Login" onclick="validate(document.myForm.email)"></div>
		</form>
		<a href="register.html">join us</a>
	</div>
</body>

</html>