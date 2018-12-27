<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="com.onlineInterview.Entities.Interview"%>
<%@page import="com.onlineInterview.Entities.UserExam"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
List <UserExam> exams = (List<UserExam>)request.getAttribute("exams");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="">
			
		<%  for(int i=0;i<exams.size();i++) { %>
			<div class="">
				<div>
            	<a class="" href="examQuestions?examId=<%=exams.get(i).getId()%>">
					<%out.print(exams.get(i).getId());%> 
				</a>
				</div>

			</div>
		<% } %>

	</div>

</body>
</html>