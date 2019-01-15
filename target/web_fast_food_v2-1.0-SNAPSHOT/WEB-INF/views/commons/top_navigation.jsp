<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="topnav">
                <ul>
                    <li><a href="/fastfood">Home</a></li>
                    <li><a href="/fastfood/about">About us</a></li>
                    <li><a href="/fastfood/contact">Contact us</a></li>
                    <security:authorize access="!hasAnyRole('ROLE_RADNIK','ROLE_MENADZER')">
                    <li style="float:right"><a href="/fastfood/login" class="active">Login</a></li>
                    </security:authorize>
                    <security:authorize access="hasAnyRole('ROLE_RADNIK','ROLE_MENADZER')">
                    <li style="float:right"><a href="/fastfood/signout" class="active">Logout</a></li>
                    </security:authorize>
                </ul>
</div>
