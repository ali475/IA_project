<%@page import = "java.util.List" %>

<%
    List<String> exams = (List<String>)request.getAttribute("examTypes");
    String userName = (String)request.getAttribute("userName");
	System.out.println("from jsp ---> "+userName);
%>

<html>
<head>
    
    <title>Page Title</title>
    <link href="css/header.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
    
</head>
<body>

    <form class="ivForm" method="GET" action="/createInterview">
        <table class="records">
            <th>exam name</th>
            <th>priority</th>
            <th>num questions</th>
            <th>dration</th>

            <%  for(int i=0;i<exams.size();i++) { %>

                <tr>
                    <td>
                        <%=exams.get(i)%>
                        <input type="checkbox" name="exam" value="<%=exams.get(i)%>">
                    </td>
                    <td> <input type="number" name="order" value="1"> </td>
                    <td> <input type="number" name="numOfQuestions" value="1"> </td>
                    <td> <input type="number" name="duration" value="20"> </td>
                </tr>

            <% } %>
        </table>
        <input type="hidden" name="userName" value="<%=userName%>">
        <input class="date" type="date" name="date">
        <input class="submitIv" type="submit" value="submit">
    </form>

</body>

</html>