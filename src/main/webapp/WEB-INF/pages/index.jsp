<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Prog.kiev.ua</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>

    <body>

            <table class="table table-striped">
                <tr>
                    <td> <li><a href="/">Default</a></li>
                    <c:forEach items="${baitTypes}" var="type">
                    <li><a href="/baitType/${type}">${type}</a></li>
                    </td>
                </tr>
                </c:forEach>
                <tr>
                    <td>
                        <li><a href="/">Default</a></li>
                        <c:forEach items="${coilTypes}" var="type">
                        <li><a href="/coilTypes/${type}">${type}</a></li>
                    </td>
                    </c:forEach>
                </tr>

                <tr>
                    <td>
                        <li><a href="/">Default</a></li>
                        <c:forEach items="${rodTypes}" var="type">
                        <li><a href="/rodTypes/${type}">${type}</a></li>
                    </td>
                    </c:forEach>
                </tr>
                </table>
    </body>
</html>