<%-- 
    Document   : update
    Created on : Jan 5, 2019, 4:03:29 PM
    Author     : Mihailo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wrapper">
            <form:form method="POST" commandName="zaposleni">
                <form:hidden path="id"/>
                <fieldset class="form_group">
                    <form:label path="ime">Ime</form:label>
                    <form:input path="ime" name="ime" type="text" class="form_group" required="required"/>
                </fieldset>
                <fieldset class="form_group">
                    <form:label path="adresa">Adresa</form:label>
                    <form:input path="adresa" name="adresa" type="text" class="form_group" required="required"/>
                </fieldset>
                <fieldset class="form_group">
                    <form:label path="telefon">Telefon</form:label>
                    <form:input path="telefon" name="telefon" type="text" class="form_group" required="required"/>
                </fieldset>
                <fieldset class="form_group">
                    <form:label path="lozinka">Lozinka</form:label>
                    <form:input path="lozinka" name="lozinka" type="text" class="form_group" required="required"/>
                </fieldset>
                    <form:hidden path="tip_zaposlenog"/>
                    <form:hidden path="tip_troska"/>
                    <input type="submit" value="Submit"/>
            </form:form>
        </div>
    </body>
</html>
