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


	<form>
		<p><%= pos.getPositionName() %></p>
		<p><%= pos.getPositionDescribtion() %></p>
		Upload CV:<input type="file" name="cv" >
		<input type="hidden" name="posName" value="<%= pos.getPositionName() %>">
		<input type="submit" value="Apply">
	</form>

	<a href="mainHR.html"><input type="submit" value="Back"></a>
</body>
</html>