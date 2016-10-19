<%@include file="top.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="contact-form mar-top30">
            <a href="admin/marka">   <input  type="button" class="button" value="<-NAZAD" /></a>
            


<!--            <form:form name="unosForma" method="POST" action="./admin/markaadd" commandName="newMarka">
                <form:input path="ime" type="text" />
                <form:input path="opis" type="text" />
                <input type="submit" value="Add" />
            </form:form>
            -->
            <label> 
                <form action="./admin/markaadd" name="unosForma" comandName="newMarka" method="post"/>
            </label>
            <label> <span>Ime</span>
                <input path="ime" type="text" class="input_text" name="ime" id="email" value="${Marka.ime}"/>
            </label>
            
            <label> <span>Opis</span>
                <input path="opis" type="text" class="input_text" name="opis" id="subject" value="${Marka.opis}"/>
            </label>
            <input type="submit" class="button" name="add" value="    add     " />  
        </div>




    </form>

</body>
</html>
