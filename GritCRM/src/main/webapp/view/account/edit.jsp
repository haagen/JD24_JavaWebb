<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="pageTitle" value="GritCRM - Account" />
<%@ include file="/WEB-INF/fragments/header.jsp" %>

<%@ include file="/WEB-INF/fragments/navbar.jsp"%>

<h2>Edit Account</h2>

<form method="POST" action="/accounts">

    <input type="hidden" name="id" value="${account.id}" >

    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" name="name" id="name" placeholder="Acme Inc" value="${account.name}">
    </div>
    <div class="mb-3">
        <label for="address" class="form-label">Address</label>
        <input type="text" class="form-control" name="address" id="address" placeholder="Street no 1337" value="${account.address}">
    </div>
    <div class="mb-3">
        <label for="zip" class="form-label">Postal Code</label>
        <input type="text" class="form-control" name="zip"  id="zip" placeholder="222 33" value="${account.zip}">
    </div>
    <div class="mb-3">
        <label for="city" class="form-label">City</label>
        <input type="text" class="form-control" name="city"  id="city" placeholder="Big City" value="${account.city}">
    </div>
    <div class="mb-3">
        <label for="country" class="form-label">Country</label>
        <input type="text" class="form-control" name="country"  id="country" placeholder="Great Country" value="${account.country}">
    </div>
    <!-- implementera alla de andra fälten -->
    <input type="submit" value="Save" class="btn btn-primary">
    <a href="/accounts" class="btn btn-secondary ms-2">Cancel</a>

</form>



<%@ include file="/WEB-INF/fragments/footer.jsp" %>