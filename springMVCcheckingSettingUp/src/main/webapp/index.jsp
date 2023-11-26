<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Airport</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 0.5em 0;
        }

        form {
            margin: 20px auto;
            background-color: #ccffcc; 
            padding: 15px;
            border-radius: 10px;
            max-width: 400px; 
            margin: 0 auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        a {
            text-decoration: none;
            color: #333;
        }

        a:hover {
            color: #555;
        }

        .highlight {
            background-color: #ffcc66; /* Light yellow */
            padding: 5px;
            border-radius: 5px;
        }
    </style>
</head>
<body>

    <header>
        <h1>Your Page Header</h1>
    </header>

    <form action="gotoForm">
        <table>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><input type="text" id="name" name="airportName" value=""></td>
            </tr>
            <tr>
                <td><label for="location">Location:</label></td>
                <td><input type="text" id="location" name="location" value=""></td>
            </tr>
            <tr>
                <td><label for="planes">Planes:</label></td>
                <td><input type="number" id="planes" name="noOfPlanes" value=""></td>
            </tr>
            <tr>
                <td><label for="runway">Runway:</label></td>
                <td><input type="number" id="runway" name="noOfRunways" value=""></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit"></td>
            </tr>
        </table>
    </form>

    <h2>${responseMessage}</h2>

    <form action="gotoSearch" style="background-color: #ffb3b3; /* Light red */">
        <table>
            <tr>
                <td><label for="searchId">Enter ID:</label></td>
                <td><input type="number" id="searchId" name="airportId"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>

    <h1>${ID}</h1>
    <h1>${NAME}</h1>
    <h1>${LOCATION}</h1>
    <h1>${PLANES}</h1>
    <h1>${RUNWAYS}</h1>

    <form action="search" style="width: 50%; margin: 20px auto; text-align: center; background-color: #ffd699; /* Light orange */">
        <table>
            <tr>
                <td><label for="searchName">Name:</label></td>
                <td><input type="text" id="searchName" name="airportName" value=""></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Search"></td>
            </tr>
        </table>
    </form>

    <h1>${id}</h1>
    <h1>${name}</h1>
    <h1>${location}</h1>
    <h1>${planes}</h1>
    <h1>${runway}</h1>

    <a href="getdetails" class="highlight">GetAirportDetails</a>

    <table border="2">
        <tr>
            <th>AIRPORT_ID</th>
            <th>AIRPORT_NAME</th>
            <th>AIRPORT_LOCATION</th>
            <th>No_OF_PLANES</th>
            <th>No_OF_RUNWAYS</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
        <tr>
            <c:forEach var="airport" items="${Airports}" >
                <td>${airport.airportId }</td>
                <td>${airport.airportName }</td>
                <td>${airport.airportLocation}</td>
                <td>${airport.noOfPlanes}</td>
                <td>${airport.noOfRunways }</td>
                <td><a href="editAirport/${airport.airportId}">edit</a></td>
                <td><a href="deleteAirport/${airport.airportId }">delete</a></td>
            </tr>
        </c:forEach>
    </table>   
    <h1>${deletemessage}</h1>

    <footer>
        <p>Your Page Footer</p>
    </footer>

</body>
</html>
