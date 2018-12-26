<%@page import = "java.util.List" %>
<%@page import = "com.onlineInterview.Entities.Position" %>
<%@page import = "com.onlineInterview.Entities.Candidate" %>
<%
    List<Candidate> cans = (List<Candidate>)request.getAttribute("applicants");
%>

<html>

<head>
	<title>applicants</title>
	<link href="css/header.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
</head>

<body>

	<table class="records">

		<th>Candidate Name</th>
		<th>Candidate CV</th>
		<th>Reject</th>
		<th>Evaluate</th>

		<%  for(int i=0;i<cans.size();i++) { %>
			<tr>
				<td> <%out.println(cans.get(i).getUserNAme());%> </td>
				<td> <a href="#"> cv </a> </td>
				<td>
					<a href="/rejectCandidate?userName=<%=cans.get(i).getUserNAme()%>">
						reject
					</a>
				</td>
				<td>
					<a href="/evaluateCandidate?userName=<%=cans.get(i).getUserNAme()%>">
						evaluate
					</a>
				</td>
			</tr>
		<% } %>

	</table>

</body>

</html>