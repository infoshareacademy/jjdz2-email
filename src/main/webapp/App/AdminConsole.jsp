<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JBD Email Search Engine</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link href="resources/css.css" rel="stylesheet" type="text/css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<jsp:directive.include file="../header.jsp"/>
<script type="text/javascript" src="LogoutFB.js">
</script>
<h1>Welcome</h1>
<p>Add new admins or edit existing one</p>
<p>Welcome! ${sessionData.username} </p>
<button onclick="Logout()">Logout From FB</button>


<div class="jumbotron">
    <form method="post" action="search">
        <button class="btn btn-warning" onclick="location.href=search">SearchButton</button>
    </form>
    <p>Add new admin or edit exisitng one </p>
    <form method="post" action="update">
        <ul>
            <c:forEach items="${userList}" var="user">
                <li> ${user.id} . ${user.username} - ${user.privilege}<input type="checkbox" name="isPrivileged"
                                                                             value=${user.id}></li>
            </c:forEach>
            <input class="btn btn-warning" type="submit" value="Update">
        </ul
    </form>
    <jsp:directive.include file="../footer.jsp"/>
</div>
</body>
</html>
