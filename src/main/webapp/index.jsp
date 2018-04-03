<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel = "stylesheet" type = "text/css" href = "view/css/styles.css">
<html>
<head>
    <title>Title</title>

</head>
<body>
<div class = "register">
    <div class="cl-wh" id="f-mlb">Create an account</div>
    <form method = "post" action = "servlet">
        <label class="cl-wh f-lb">Name</label>
        <div class="f-i-bx b3 mrg3b">
            <div class="tb">
                <div class="td icn"></div>
                <div class="td prt">
                    <input type="text" value = '<c:out value="${requestScope.oldname}"/>' name = "name">
                </div>
            </div>
        </div>
        <label class="cl-wh f-lb">Email address</label>
        <div class="f-i-bx b3 mrg3b">
            <div class="tb">
                <div class="td icn"></div>
                <div class="td prt">
                    <input type="email" value = '<c:out value="${requestScope.oldemail}"/>' name = "email">
                </div>
            </div>
        </div>
        <label class="cl-wh f-lb">Login</label>
        <div class="f-i-bx b3">
            <div class="tb">
                <div class="td icn"></div>
                <div class="td prt">
                    <input type="text" value = '<c:out value="${requestScope.oldlogin}"/>' name = "login">
                </div>
            </div>
        </div>
        <c:if test = '${ requestScope.errorMsg != null }'>
            <div class = "error tb"><c:out value="${ requestScope.errorMsg }"/></div>
        </c:if>

        <div id="tc-bx">You agree to our <a href="#">terms and conditions</a> &amp; <a href="#">privacy policies</a>.</div>
        <div id="s-btn" class="mrg25t"><input type="submit" value="Sign up" class="b3"></div>
    </form>
</div>
</body>
</html>
