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
    <h1>Search Results</h1>
    <form action="/ads" method="post">
        <div class="form-group">
            <label for="searchQuery">Search</label>
            <input id="searchQuery" name="searchQuery" class="form-control" type="text">
        </div>
    </form>
    <c:if test="${not empty searchResults}">
        <table>
            <c:forEach var="ad" items="${searchResults}">
                <tr>
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty searchResults}">
        <p>No results found.</p>
    </c:if>
</div>
</body>
</html>
