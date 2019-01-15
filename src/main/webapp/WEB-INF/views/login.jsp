<%-- 
    Document   : login
    Created on : Jan 14, 2019, 7:22:04 PM
    Author     : Mihailo
--%>
<c:url value="/login" var="loginUrl"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custom login</title>
    </head>
    <body onload='document.f.username.focus();'>
       <h3>Login with Ime and Lozinka</h3>
       <form name='f' action="${loginUrl}" method="POST">
           <c:if test="${param.error == null}">        
		<p>
                    ${param.error==null }
<!--			Invalid username and password.-->
		</p>
	</c:if>
	<c:if test="${param.logout != null}">       
		<p>
<!--			You have been logged out.--> ${param.logout}
		</p>
	</c:if>
           <table>
               <tr>
                   <td>Ime:</td>
                   <td><input type="text" name="username" value=""/></td>
               </tr>
                <tr>
                   <td>Password:</td>
                   <td><input type="password" name="password"/> </td>
               </tr>
               <tr>
                   <td>Remeber me:</td>
                   <td><input type="checkbox" name="remember-me"/> </td>
               </tr>
               <tr>
                  
                   <td colspan="2"><input type="submit" value="Login"/> </td>
               </tr>
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
           </table>
       </form>
    </body>
</html>
