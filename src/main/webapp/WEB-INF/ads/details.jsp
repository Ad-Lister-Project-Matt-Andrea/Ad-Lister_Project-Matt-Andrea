<%--
  Created by IntelliJ IDEA.
  User: mattguardiola
  Date: 3/17/23
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container card border shadow-lg mt-3">
    <div class="row d-flex justify-content-between">
        <h1 class="col col-4 text-primary">${ad.title}</h1>
        <div class="container col col-2"></div>
        <div class="container col col-1"></div>
        <div class="container col col-1 d-flex">

            <a href="http://gmail.com"><button class="btn btn-primary m-2" type="button">contact ${user.email}</button></a>
        </div>
    </div>
        <br>
    <table>
        <tr>
            <h2>Price:</h2>
            <h5>$${ad.price}</h5>
            <br>
        </tr>
        <tr>
            <h2>Description:</h2>
            <h5>${ad.description}</h5>
            <br>
        </tr>
        <tr>
            <h2>General location:</h2>
            <h5>${ad.location}</h5>
            <br>
        </tr>
        <tr>
            <h2>Categories:</h2>
            <c:forEach var="cat" items="${ad.categories}">
                <h5 value="${cat.id}">${cat.name}</h5>
            </c:forEach>
        </tr>
    </table>

</div>
</body>
</html>
