<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <% if (request.getSession().getAttribute("user") == null) { %>
            <li><a href="/ads">View All Ads</a></li>
            <li><a href="/login">Login</a></li>
            <% } else { %>
            <li><a href="/ads">View All Ads</a></li>
            <li><a href="/ads/create">Create A Listing</a></li>
            <li><a href="/profile">Profile</a></li>
            <li><a href="/logout">Logout</a></li>
            <% } %>







<%--            <li><a href="/profile">Profile</a></li>--%>
<%--            <li><a href="/ads">View All Ads</a></li>--%>
<%--            <li><a href="/ads/create">Create A Listing</a></li>--%>
<%--            <li><a href="/login">Login</a></li>--%>
<%--            <li><a href="/logout">Logout</a></li>--%>
        </ul>
    </div>
    </div>
</nav>
