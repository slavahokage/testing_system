<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">


</head>



<a href="controller?command=go_to_index">Main page</a>
<br>



${requestScope.error}

${requestScope.success}

${requestScope.exception}

<form action="controller" method="post">
		<input type="hidden" name="command" value="authorization">

	<table>
		<tr>
			<td>
				Login:
			</td>

			<td>
				<input type="text" name="login" value="" /> <br />
			</td>
		</tr>

		<tr>
			<td>
				Password
			</td>
			<td>
				<input type="password" name="password" value="" /> <br />
			</td>
		</tr>

	</table>

	<input type="submit" name="submit" value="Sign up" />
</form>

 

</body>
</html>