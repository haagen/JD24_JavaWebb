<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../WEB-INF/fragments/header.jsp" %>


<h1><%= "Hello World!" %></h1>
<a href="hello-servlet">Hello Servlet</a>

<b>Användare:</b> ${sessionScope.user.username}


<%@ include file="../WEB-INF/fragments/footer.jsp" %>