<%@page import = "java.util.List" %>
<%@page import = "com.onlineInterview.Entities.Position" %>

<%
    List<Position> positions = request.getAttribute("positions", positions);
%>

<html>

<head>
	<title>Home</title>
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
        <%  foreach(Position p: positions) { %>
            <p> <%=p.getPositionName()%> </p>
        <% } %>
    </div>
	
	

</body>

</html>