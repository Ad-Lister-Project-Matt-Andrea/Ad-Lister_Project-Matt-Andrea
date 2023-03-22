<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
    <title>Search Results</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <div class="container card border shadow-lg mb-3">
        <h1 class="pt-4">Search Results</h1>
        <form action="/ads" method="post">
            <div class="form-group">
                <label for="searchQuery"></label>
                <input id="searchQuery" name="searchQuery" class="form-control" type="text" placeholder="Search">
            </div>
        </form>
    </div>
    <c:if test="${not empty searchResults}">
        <table>
            <c:forEach var="ad" items="${searchResults}">
                <div class="card container border shadow-lg p-2 ">
                    <div class="card-body">
                        <a href="/ads/details?id=${ad.id}" class="text-decoration-none "><h2>${ad.title}</h2></a>
                        <p>${ad.description}</p>
                    </div>
                </div>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty searchResults}">
        <p>No results found.</p>
    </c:if>
</div>
</body>
</html>
