<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="GritCRM - Contact" />
<%@ include file="/WEB-INF/fragments/header.jsp" %>
<%@ include file="/WEB-INF/fragments/navbar.jsp" %>


<h2>Create or update contact</h2>

<form method="POST" action="/contacts">
  <input type="hidden" name="id" value="${contact.id}">
  <input type="hidden" name="accountId" value="${accountId}">
  <div class="mb-3">
    <label for="name" class="form-label">Name</label>
    <input type="text" class="form-control" name="name" id="name" placeholder="Arne Anka" value="${contact.name}">
  </div>
  <div class="mb-3">
    <label for="email" class="form-label">Email</label>
    <input type="email" class="form-control" name="email" id="email" placeholder="name@domain.tld" value="${contact.email}">
  </div>
  <div class="mb-3">
    <label for="phone" class="form-label">Phone</label>
    <input type="text" class="form-control" name="phone"  id="phone" placeholder="+xx xxx xx x" value="${contact.phone}">
  </div>
  <input type="submit" value="Save" class="btn btn-primary"><a href="/contacts"  class="btn btn-secondary ms-2">Cancel</a>
</form>


<%@ include file="/WEB-INF/fragments/footer.jsp" %>