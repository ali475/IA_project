<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
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
<body>
	<form name="myForm" action="login">
		Email:<input type="email" name="email" id="email" required="true" onchange="AJAXmail()"><div id="exist"></div>
		<input type="radio" name="type" id="type" value="a"> Applicant
	    <input type="radio" name="type" id="type"  value="h"> HR <br>
		Password:<input type="password" name="password" id="password" required="true"><br>
		<input type="submit" value="Login" onclick="validate(document.myForm.email)">
	</form>
	<a href="register.html">join us</a>
</body>
</html>