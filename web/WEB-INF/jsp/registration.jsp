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

<title>Insert title here</title>
</head>
<body>


	<fmt:setLocale value="${sessionScope.local}" />
	<fmt:setBundle basename="resources.locale" var="loc" />
	<fmt:message bundle = "${loc}" key = "locale.registration.enter_login_message" var="enter_login"/>
	<fmt:message bundle = "${loc}" key = "locale.registration.enter_password_message" var="enter_login"/>
	
	 	<div align = "right"> 
	  		<form action= "controller" method="post" > 
				<input type="hidden" name="command" value="change_locale">
				<input type="hidden" name="locale" value="ru">
				<input type="submit" name="submit" value="ru" /> 
			</form>
	 		
			<form action= "controller" method="post" > 
				<input type="hidden" name="command" value="change_locale">
				<input type="hidden" name="locale" value="eng">
				<input type="submit" name="submit" value="eng" /> 
			</form>
			
			
		</div>



	<form action="controller" method="post">
		<input type="hidden" name="command" value="registration">

		<%-- ${enter_login}:  --%>


	<h1>

	${requestScope.error}
    ${requestScope.success}
    ${requestScope.fault}
	</h1>

	<br>
	<br>

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