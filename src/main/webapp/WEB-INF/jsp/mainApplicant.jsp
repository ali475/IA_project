<%@page import = "java.util.List" %>
<%@page import = "com.onlineInterview.Entities.Position" %>

<%
    List<Position> positions = (List<Position>)request.getAttribute("positions");
%>

<html>

<head>
	<title>Home</title>
	<link href="css/index.css" rel="stylesheet">
	<link href="css/inputs.css" rel="stylesheet">
</head>

<body>
	<div class="header">
		<a href="#default" class="logo"><img class="logoImg" src="images/infinity.jpg"></a>
		<div class="header-right">
			<a class="active" href="positions">Available positions</a>
			<a href="#contact">My applications</a>
			<a href="#about">Updates</a>
		</div>
	</div>
        
    <div class="positions-con">
        <%  for(int i=0;i<positions.size();i++) { %>
            <a  href="apply?pName=<%=positions.get(i).getPositionName()%>"> <%out.print(positions.get(i).getPositionName());%> </a>
        <% } %>
    </div>
	
	

</body>

</html>