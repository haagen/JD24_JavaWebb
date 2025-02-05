<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/fragments/header.jsp" %>
<%@ include file="/WEB-INF/fragments/navbar.jsp" %>


<h2>Contact Details</h2>

<a href="/contacts" class="btn btn-primary">Back to list</a>

<hr class="mt-5 mb-5">

<p class="strong">Contact Name</p>
<p>${contact.name}</p>
<p class="strong">Email</p>
<p>${contact.email}</p>
<p class="strong">Phone</p>
<p>${contact.phone}</p>
<a href="/contacts?editId=${contact.id}" class="btn btn-primary">Edit contact</a>
<hr class="mt-5 mb-5">


<%@ include file="/WEB-INF/fragments/footer.jsp" %>