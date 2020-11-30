<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Registration</title>
</head>
<body>


<a href="controller?command=go_to_index">Main page</a>


	<form action="controller" method="post">
		<input type="hidden" name="command" value="registration">



        <c:forEach var="error" items="${requestScope.errors}">
            <c:out value="${error}" />
            <c:out  value="${'<br>'}" escapeXml="false"/>
        </c:forEach>

    ${requestScope.success}

    ${requestScope.exception}

        <table>
            <tr>
                <td>
                    Enter login:
                </td>

                <td>
                    <input type="text" name="login" value="" /> <br />
                </td>
            </tr>

            <tr>
                <td>
                    Enter password:
                </td>
                <td>
                    <input type="password" name="password" value="" /> <br />
                </td>
            </tr>

            <tr>
                <td>
                    Enter e-mail:
                </td>
                <td>
                    <input type="email" name="email" value="" /> <br />
                </td>
            </tr>

            <tr>
                <td>
                    Enter name:
                </td>
                <td>
                    <input type="name" name="name" value="" /> <br />
                </td>
            </tr>

            <tr>
                <td>
                    Enter surname:
                </td>
                <td>
                    <input type="surname" name="surname" value="" /> <br />
                </td>
            </tr>

        </table>




		<input type="submit" name="submit" value="register me" />


	</form>
</body>

</html>