<%@page import = "java.util.List" %>
<%@page import = "com.onlineInterview.Entities.Position" %>

<%
    Position pos = (Position)request.getAttribute("position");
%>

<html>
<head>
	<title>applicants</title>
</head>
<body>


	<form action="upload" method="POST">
		<p><%= pos.getPositionName() %></p>
		<p><%= pos.getPositionDescribtion() %></p>
		Upload CV:<input type="file" name="cv" >
		<input type="hidden" name="posName" value="<%= pos.getPositionName() %>">
		<input type="submit" value="Apply">
	</form>

</body>
</html>