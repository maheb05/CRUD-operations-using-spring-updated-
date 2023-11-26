<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Runway</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
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

        h2 {
            color: #333;
        }

        /* Form-specific colors */
        .form1, .form2, .form3 {
            background-color: #ccffcc; /* Light green */
            border-radius: 10px;
        }

        .form2 {
            background-color: #e6f7ff; /* Light blue */
        }

        .form3 {
            background-color: #ffb3b3; /* Light red */
        }
    </style>
</head>
<body>

    <table>
        <tr>
            <td class="form1">
                <form action="saveRunwayDetails">
                    <pre>
                        Runway Length:<input type="number" name="runwayLength">
                        Runway Width:<input type="number" name="runwayWidth">
                        Surface Type:<input type="text" name="surfaceType">
                        Availability:<input type="text" name="availability">
                        <input type="submit">
                    </pre>
                </form>
            </td>
            <td class="form2">
                <form action="readById">
                    Runway Id:<input type="number" name="runwayID">
                    <input type="submit" value="Search">
                </form>
            </td>
        </tr>
    </table>

    <h2>${saveMessage}</h2>

    <h2>${readMessage}</h2>

    <h2>${Id}</h2>
    <h2>${Length}</h2>
    <h2>${Width}</h2>
    <h2>${Surface}</h2>
    <h2>${Availability}</h2>

    <a href="getAll">Get All Runway Details</a>
    <table border="2">
        <tr>
            <th>RUNWAY-ID</th>
            <th>RUNWAY_LENGTH</th>
            <th>RUNWAY_WIDTH</th>
            <th>SURFACE TYPE</th>
            <th>AVAILABILITY</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
        <c:forEach var="runway" items="${Runways}" >
            <tr>
                <td>${runway.runwayID}</td>
                <td>${runway.runwayLength}</td>
                <td>${runway.runwayWidth}</td>
                <td>${runway.surfaceType}</td>
                <td>${runway.availability}</td>
                <td><a href="editRecord/${runway.runwayID}">edit</a></td>
                <td><a href="deleteRecord/${runway.runwayID}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <h2>${errorMessage}</h2>
    <h2>${updateMessage}</h2>
    <h2>${deleteMessage}</h2>

</body>
</html>