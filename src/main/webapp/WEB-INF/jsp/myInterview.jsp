<%@page import = "java.util.List" %>
<%@page import = "com.onlineInterview.Entities.Interview" %>

<%
    List<Interview> ivs = (List<Interview>)request.getAttribute("ivs");
%>

<html>

<head>
	<title>Interview</title>
	<link href="css/mainApplicant.css" rel="stylesheet">
	<link href="css/inputs.css" rel="stylesheet">
	<link href="css/header.css" rel="stylesheet">
</head>

<body>

	<div class="header">

		<a href="#default" class="logo"><img class="logoImg" src="images/infinity.jpg"></a>
		<div class="header-right">
			<a class="active" href="mainApplicant">Available positions</a>
			<a href="#contact">My applications</a>
			<a href="#about">Updates</a>
		</div>

	</div>

	<div class="">
			
		<%  for(int i=0;i<ivs.size();i++) { %>
			<div class="">
				<div>
            	<a class="" href="exams?iv_Id=<%=ivs.get(i).getId()%>">
					<%out.print(ivs.get(i).getId());%> 
				</a>
				</div>

			</div>
		<% } %>

	</div>
	
	

</body>

</html>