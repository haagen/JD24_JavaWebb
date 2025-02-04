<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../WEB-INF/fragments/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col">
        <h1>Login to GritCRM</h1>

        <form method="POST" action="/login">

            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    ${error}
                </div>
            </c:if>
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" id="username" name="username" value="${username}" class="form-control" aria-describedby="usernameHelp">
                <div id="usernameHelp" class="form-text">Enter your username here!</div>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" id="password" name="password" class="form-control" aria-describedby="passwordHelp">
                <div id="passwordHelp" class="form-text">Enter your password here!</div>
            </div>

            <button type="submit" class="btn btn-primary">Login</button>

        </form>

    </div>
</div>



<%@ include file="../WEB-INF/fragments/footer.jsp" %>