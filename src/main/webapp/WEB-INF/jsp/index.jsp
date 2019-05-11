<!DOCTYPE html>
<html>
<head>

	<title>Login</title>
	<link href="css/index.css" rel="stylesheet">
	<link href="css/inputs.css" rel="stylesheet">
	<link href="css/header.css" rel="stylesheet">

</head>

<body class="body">

	<div class="header">
		<a href="#default" class="logo"><img class="logoImg" src="images/infinity.jpg"></a>
		<div class="header-right">
			<a class="active" href="#home">Home</a>
			<a href="#contact">Contact</a>
			<a href="#about">About</a>
			<a href="/register">Register</a>
		</div>
	</div>

	<div class="login">

		<form name="loginForm" action="login" method="GET">
			<input class="inputField" type="text" name="email" id="email" required="true" placeholder="user name">
			<br>
			<input class="inputField" type="password" name="password" id="password" required="true" placeholder="password">
			<br>
			<div class="userType">
				<input class="radio" type="radio" name="type" id="type" value="a" checked> <label for="type">Applicant</label>
				<input class="radio" type="radio" name="type" id="type"  value="h"> <label for="type">HR</label>
			</div>
			<div class="btn-container"><input class="submitButton" type="submit" value="Login" ></div>
		</form>
		
	</div>
</body>

</html>