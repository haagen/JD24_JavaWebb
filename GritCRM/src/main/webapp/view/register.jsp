<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="GritCRM - Register" />
<%@ include file="/WEB-INF/fragments/header.jsp" %>

<h1>Registrera till CRM</h1>
<c:if test="${empty success}">
    <form method="POST" action="/register">
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                    ${error}
            </div>
        </c:if>
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username" aria-describedby="usernameHelp" name="username" value="${username}">
            <div id="usernameHelp" class="form-text">Enter your username here</div>
        </div>
        <div class="mb-3">
            <label for="password1" class="form-label">Password</label>
            <input type="password" class="form-control" id="password1" name="password1" value="${password1}">
        </div>
        <div class="mb-3">
            <label for="password2" class="form-label">Password (again)</label>
            <input type="password" class="form-control" id="password2" name="password2" value="${password2}">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <p>You already have an account, you can <a href="/view/login.jsp">sign in here</a>.</p>
</c:if>
<c:if test="${not empty success}">
    <div class="alert alert-alert alert-success" role="alert">
            ${success}
    </div>
    <p>
        <a href="login">Click here to login!</a>
    </p>
</c:if>

<%@ include file="/WEB-INF/fragments/footer.jsp" %>