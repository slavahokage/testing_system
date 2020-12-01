<%@ page language="java" import="by.htp.vyacheslav.entity.*" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>

<body>

<c:if test="${sessionScope.user != null}">
    <h5> You login as ${sessionScope.user}</h5>
    <a href="controller?command=sign_out">sign out</a>
</c:if>
<ul>
    <li><a href="controller?command=go_to_registration">Registration</a></li>
    <li><a href="controller?command=go_to_authorization">Sign In</a></li>
</ul>

</body>

</html>