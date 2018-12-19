<!DOCTYPE html>
<script src="jquery-3.3.1.min.js"></script>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
</head>
<body>
<p id = "ii"></p>
   <input type="button" name = "b1" value="test" id = "b1" onclick="send()">
   <dev id = "ali" ></dev>
</body>
<script type="text/javascript">

function send(){
	var xhttp = new XMLHttpRequest();
	xhttp.open("GET", "test", true);
	xhttp.send();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {

           $("ii").innerHTML=  xhttp.responseText;
	    }
	};


}
</script>
</html>