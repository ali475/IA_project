<!DOCTYPE html>
<html>
<head>
	<title>applicants</title>
</head>
<body>



<%
int number_of_positions =(int) request.getAttribute("number_of_positions");
String [] positions = new String[number_of_positions]; 
for (int i=0 ;i<number_of_positions;i++){
	positions[i] = (String)request.getAttribute("Position"+i);
	out.print(positions[i]);
}

%>
	<a href="mainHR.html"><input type="submit" value="Back"></a>
</body>
</html>