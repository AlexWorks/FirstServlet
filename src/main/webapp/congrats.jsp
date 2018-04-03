<%--
  Created by IntelliJ IDEA.
  User: ok
  Date: 28.03.2018
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel = "stylesheet" type = "text/css" href = "view/css/styles.css">
</head>
<body>
    <h1 class = "header" >Congratulations! Registration Successful!</h1>
    <p>Your name: <c:out value="${requestScope.name}"/> </p>
    <p>Your email: <c:out value="${requestScope.email}"/> </p>
    <p>Your login: <c:out value="${requestScope.login}"/></p>
</body>
</html>
