<%@ page import="se.grit.dag3.database.DB" %>
<%@ page import="se.grit.dag3.models.Fruit" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Fruit[] fruits = DB.fruits;
    request.setAttribute("fruits", fruits);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Webbutveckling med Java - dag 3</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        .grit {
            background-color: lightseagreen;
        }
    </style>
</head>
<body>
    <%@include file="WEB-INF/fragments/header.jspf"%>

    <div class="container">
        <div class="row">
            <div class="col grit">
                <h2><%= "Hello, Fruit!" %></h2>
                <p>
                    <a href="hello-servlet">Hello Servlet</a>
                    <a href="fruitList">Fruktlistan</a>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <h2>Martins favorit frukter</h2>
                <ul>
                    <c:forEach items="${fruits}" var="f">
                        <c:if test="${f.name != \"Grape\"}">
                            <li>${f.name}</li>
                        </c:if>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>

</body>
</html>