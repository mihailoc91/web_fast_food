<%-- 
    Document   : index
    Created on : Dec 28, 2018, 5:10:38 PM
    Author     : Mihailo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="/resources/style.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/side_navi.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/top_navi.css"/>" rel="stylesheet"/>
    </head>
    
    <body>
        <%@include file="commons/side_navigation.jsp" %>
        <div class="wrapper" id="wrapper">
            <%@include file="commons/top_navigation.jsp" %>
            
            <div class="container">
                <div class="banner">
                    <h3>-introducing-</h3>
                    <h1>FATTY BURGER</h1>

                    <div class="inner_banner">
                        <div class="banner_content">
                            <p>A double layer of sear-sizzled 100% pure beef mingled with special sauce on a sesame seed bun and topped with melty American cheese, crisp lettuce, minced onions and tangy pickles.</p>
                            <p>*Based on pre-cooked patty weight.</p>							
                        </div>
                        <div class="stamp">
                            <img src="images/stamp.png" alt="" />
                        </div>
                    </div>
                </div>
            </div>
            
            
        </div>
            <script src="<c:url value="/resources/side_navi.js"/>"></script>
    </body>
</html>
