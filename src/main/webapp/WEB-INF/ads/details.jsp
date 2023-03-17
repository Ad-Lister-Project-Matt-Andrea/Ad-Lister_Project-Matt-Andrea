<%--
  Created by IntelliJ IDEA.
  User: mattguardiola
  Date: 3/17/23
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<h1> THIS IS THE DETAILS PAGE </h1>
<table>
    <tr>
        <td>Title:</td>
        <td>${ad.title}</td>
    </tr>
    <tr>
        <td>Description:</td>
        <td>${ad.description}</td>
    </tr>
</table>
</body>
</html>
