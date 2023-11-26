<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Taxi Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 20px;
        }

        h1 {
            color: #333;
        }

        table {
            background-color: #fff;
            padding: 20px;
            margin-top: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 50%;
            margin-left: auto;
            margin-right: auto;
        }

        table tr,
        table td {
            border: 1px solid #ddd;
            padding: 10px;
        }

        input[type="number"],
        input[type="text"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Edit Taxi Details</h1>
    <form action="${pageContext.request.contextPath}/updateTaxi">
        <table>
            <tr>
                <td>Taxi Id:</td>
                <td><input type="number" name="taxiID" value="${Id }"></td>
            </tr>
            <tr>
                <td>Driver Name:</td>
                <td><input type="text" name="driverName" value="${Name }"></td>
            </tr>
            <tr>
                <td>Driver Contact:</td>
                <td><input type="number" name="driverContact" value="${Contact }"></td>
            </tr>
            <tr>
                <td>TAXI MODEL:</td>
                <td><input type="text" name="model" value="${Model }"></td>
            </tr>
            <tr>
                <td>TAXI COLOR:</td>
                <td><input type="text" name="taxiColor" value="${Color }"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
