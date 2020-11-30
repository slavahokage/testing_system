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

<c:if test="${cookie.user != null && cookie.persist != ''}">
    <h5> You login as ${cookie['user'].value}</h5>
</c:if>
<ul>
    <li><a href="controller?command=go_to_registration">Registration</a></li>
    <li><a href="controller?command=go_to_authorization">Sign In</a></li>
</ul>

</body>

</html>