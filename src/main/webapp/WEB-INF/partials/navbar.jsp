<nav class="navbar navbar-light bg-light navbar-expand-lg border">
    <div class="container-fluid pt-2 pb-2">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header navbar-brand">
            <a class="link-primary text-decoration-none" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right d-flex flex-row ">
            <% if (request.getSession().getAttribute("user") == null) { %>
<%--            <li class="nav-item pe-3"><a href="/ads" class="link-secondary">View All Ads</a></li>--%>
            <li class="nav-item "><a href="/login" class="link-secondary text-decoration-none">Login</a></li>
            <% } else { %>
<%--            <li class="nav-item pe-3"><a href="/ads" class="link-secondary">View All Ads</a></li>--%>
            <li class="nav-item pe-3"><a href="/ads/create" class="link-secondary text-decoration-none">Create A Listing</a></li>
            <li class="nav-item pe-3"><a href="/profile" class="link-secondary text-decoration-none">Profile</a></li>
            <li class="nav-item"><a href="/logout" class="link-secondary text-decoration-none">Logout</a></li>
            <% } %>

<%--            <li><a href="/profile">Profile</a></li>--%>
<%--            <li><a href="/ads">View All Ads</a></li>--%>
<%--            <li><a href="/ads/create">Create A Listing</a></li>--%>
<%--            <li><a href="/login">Login</a></li>--%>
<%--            <li><a href="/logout">Logout</a></li>--%>
        </ul>
    </div>
</nav>
