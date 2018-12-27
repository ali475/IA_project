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

	<div class="positions-con">
			
		<%  for(int i=0;i<ivs.size();i++) { %>
			<div class="position">
				<div>
            	<a class="position-link" href="apply?pName=<%=positions.get(i).getPositionName()%>">
					<%out.print(ivs.get(i).getId();%> 
				</a>
				</div>
				<div class="position-info">
				<h6> <%out.print(ivs.get(i).getId();%> </h6>
				</div>
			</div>
		<% } %>

	</div>
	
	

</body>

</html>