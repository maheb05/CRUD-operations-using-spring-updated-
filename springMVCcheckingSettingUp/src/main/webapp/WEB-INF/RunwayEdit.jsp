<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Runway</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        h1 {
            text-align: center;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            background-color: #ccffcc;
            padding: 15px;
            border-radius: 10px;
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

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h1>Edit Runway Details</h1>

    <form action="${pageContext.request.contextPath}/updateRunway">
        <table>
            <tr>
                <td>Runway Id:</td>
                <td><input type="number" name="runwayID" value="${ID}"></td>
            </tr>
            <tr>
                <td>Runway Length:</td>
                <td><input type="number" name="runwayLength" value="${LENGTH}"></td>
            </tr>
            <tr>
                <td>Runway Width:</td>
                <td><input type="number" name="runwayWidth" value="${WIDTH}"></td>
            </tr>
            <tr>
                <td>Surface Type:</td>
                <td><input type="text" name="surfaceType" value="${SURFACE}"></td>
            </tr>
            <tr>
                <td>Availability:</td>
                <td><input type="text" name="availability" value="${AVAILABILITY}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update"></td>
            </tr>
        </table>
    </form>

</body>
</html>
