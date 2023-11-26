<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Airport</title>
</head>
<body>
	<h2>Edit Airport Details</h2>
	<form action="${pageContext.request.contextPath}/updateAir" >

	<pre>
		ID: <input type="number" name="airportId" value="${id}">
		Name:<input type="text" name="airportName" value="${name}">
		Location:<input type="text" name="airportLocation" value="${location}">
		Planes:<input type="number" name="noOfPlanes" value="${planes}">
		Runway:<input type="number" name="noOfRunways" value="${runway}">
		<input type="submit" value="update">
	</pre>	
	
	<h2>${responseMessage}</h2>
	</form>
</body>
</html>