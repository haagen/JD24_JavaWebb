<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/fragments/header.jsp" %>
<%@ include file="/WEB-INF/fragments/navbar.jsp" %>


<h2>Account Details</h2>

<a href="/accounts" class="btn btn-primary">Back to list</a>

<hr class="mt-5 mb-5">

<p class="strong">Account Name</p>
<p>${account.name}</p>
<p class="strong"Account Address</p>
<p>${account.address}</p>
<p class="strong">Postal Address</p>
<p>${account.zip} ${account.city}</p>
<p class="strong">Country</p>
<p>${account.country}</p>
<a href="/accounts?editId=${account.id}" class="btn btn-primary">Edit account</a>
<hr class="mt-5 mb-5">

<h3>Related Contacts</h3>
<a href="/contacts?editId=&accountId=${account.id}" class="btn btn-primary">Create Contact</a>

<c:if test="${account.contacts.size() >0}">


  <table class="table">

    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Phone</th>
      <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${account.contacts}" var="contact">
      <tr>
        <td>${contact.id}</td>
        <td><a href="/contacts?id=${contact.id}">${contact.name}</a></td>
        <td>${contact.email}</td>
        <td>${contact.phone}</td>
        <td class="action">
          <a class="icon-link" href="/contacts?editId=${contact.id}">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
              <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325"/>
            </svg>
          </a>
          <a class="icon-link" href="/contacts?deleteId=${contact.id}">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
              <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5"/>
            </svg>
          </a>

        </td>
      </tr>
    </c:forEach>
    </tbody>

  </table>

</c:if>


<%@ include file="/WEB-INF/fragments/footer.jsp" %>