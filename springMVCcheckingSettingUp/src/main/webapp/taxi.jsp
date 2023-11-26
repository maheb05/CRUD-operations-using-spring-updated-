<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 20px;
        }

        h1, h2, h3 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Enter Taxi Details</h1>
    <form action="saveTaxiDetails">
        <pre>
            Driver Name: <input type="text" name="driverName">
            Driver Contact: <input type="number" name="driverContact">
            TAXI MODEL: <input type="text" name="model">
            TAXI COLOR: <input type="text" name="taxiColor">
            <input type="submit">
        </pre>
    </form>
    <h2>${saveMessage}</h2>

    <h1>Search Taxi By Id</h1>
    <form action="getTaxiById">
        Taxi Id: <input type="number" name="taxiID">
        <input type="Submit" value="search">
    </form>
    <h3>${ID}</h3>
    <h3>${NAME}</h3>
    <h3>${CONTACT}</h3>
    <h3>${MODEL}</h3>
    <h3>${COLOR}</h3>
    <h2>${fetchMessage}</h2>

    <h1><a href="getAllTaxiDetails">GetAllTaxis</a></h1>
    <table border="2">
        <tr>
            <th>TAXI_ID</th>
            <th>DRIVER_NAME</th>
            <th>DRIVER_CONTACT</th>
            <th>TAXI MODEL</th>
            <th>TAXI COLOR</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
        <c:forEach var="taxi" items="${taxiDetails}">
            <tr>
                <td>${taxi.taxiID}</td>
                <td>${taxi.driverName}</td>
                <td>${taxi.driverContact}</td>
                <td>${taxi.model}</td>
                <td>${taxi.taxiColor}</td>
                <td><a href="editTaxiById/${taxi.taxiID}">edit</a></td>
                <td><a href="deleteTaxiById/${taxi.taxiID}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <h2>${updated}</h2>
    <h2>${delete}</h2>
</body>
</html>
