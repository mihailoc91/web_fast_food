<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<security:authorize access="hasAnyRole('ROLE_RADNIK','ROLE_MENADZER')">
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="/fastfood/zaposleni">Zaposleni</a>
  <a href="/fastfood/nabavke">Nabavke</a>
  <a href="#">Clients</a>
  <a href="#">Contact</a>
</div>


<span onclick="openNav()" class="menuBtn" >
    <p><b>&#9776;</b></p>
</span>
</security:authorize>