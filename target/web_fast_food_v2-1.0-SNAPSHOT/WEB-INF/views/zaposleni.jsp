<%-- 
    Document   : zaposleni
    Created on : Jan 3, 2019, 3:57:51 PM
    Author     : Mihailo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zaposleni</title>
        <link href="<c:url value="/resources/style.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/side_navi.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/table.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/top_navi.css"/>" rel="stylesheet"/>
    </head>
    <body>
        
        <%@include file="commons/side_navigation.jsp" %>
        
        <div class="wrapper" id="wrapper">
            
            <%@include file="commons/top_navigation.jsp" %>
            
            <h1>Hello <security:authentication property="principal.username"/> </h1>
            
            <div class="selectOption">
                <form>
                    <select name="id" id="mySelect">
                        <option value="0">Select criteria for search</option>
                        <option value="1" ${id == 1? 'selected' : ''}>Menadzeri</option>
                        <option value="2" ${id == 2? 'selected' : ''}>Radnici</option>
                        <option value="3"${id == 3? 'selected' : ''}>Stalno zaposleni</option>
                        <option value="4"${id == 4? 'selected' : ''}>Zaposleni na odredjeno</option>
                    </select>
                    <input type="submit" value="Search">
                </form>
            </div>

            <div class="table">
                <table id="myTable">

                    <tr>
                        <th>Ime</th>
                        <th>Adresa</th>
                        <th>Telefon</th>
                        <th>Lozinka</th>
                        <th></th>
                        <th></th>
                    </tr>
                    
                    <c:forEach items="${zaposleni}" var="zap">
                        <tr>
                            <td>${zap.getIme()}</td>
                            <td>${zap.getAdresa()}</td>
                            <td>${zap.getTelefon()}</td>
                            <td>${zap.getLozinka()}</td>
                            <security:authorize access="hasRole('ROLE_MENADZER')">
                                <td><a href="/fastfood/zaposleni/update?id=${zap.getId()}" class="btn_update">Update</a></td>
                                <td><a href="/fastfood/zaposleni/delete?id=${zap.getId()}" class="btn_delete">Delete</a></td>
                            </security:authorize>
                        </tr>
                    </c:forEach>
                        
                </table>
            </div>
        </div>
        <script src="<c:url value="/resources/side_navi.js"/>"></script>
        <script src="<c:url value="/resources/table.js"/>"></script>
    </body>
</html>
