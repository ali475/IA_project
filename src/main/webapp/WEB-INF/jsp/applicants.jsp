<%@page import = "java.util.List" %>
<%@page import = "com.onlineInterview.Entities.Position" %>
<%@page import = "com.onlineInterview.Entities.Candidate" %>
<%
    List<Candidate> cans = (Candidate)request.getAttribute("applicants");
%>

<html>

<head>
	<title>applicants</title>
</head>

<body>

	<%  for(int i=0;i<cans.size();i++) { %>

		<a href="#">
			<%out.println(can.get(i).getUserNAme());%> 
		</a>

	<% } %>

</body>

</html>