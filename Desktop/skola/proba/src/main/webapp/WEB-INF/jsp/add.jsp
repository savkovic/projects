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
            
            



            <label> 
                <form action="./admin/add" name="unosForma" comandName="newAutomobil" method="post" enctype="multipart/form-data"/>
            </label>
            <label> <span>model</span>
                <input path="model" type="text" class="input_text" name="model" id="email" value="${automobil.model}"/>
            </label>
            
            <label> <span>Opis</span>
                <input path="opis" type="text" class="input_text" name="opis" id="subject" value="${automobil.opis}"/>
            </label>
            <label> <span>cena</span>
                <input path="cena" type="text" class="input_text" name="cena" id="subject" value="${automobil.cena}"/>
            </label>
             <label> <span>marka</span>
                 
                 
                 <select name="marka" class="input_text">
                <c:forEach items="${marka}" var="marka">
                    <option <c:if test="${marka.id==automobil.marka}">selected</c:if> value="${marka.id}">${marka.ime}</option>    
                </c:forEach>
                 </select>
                 <label> <span>slika</span>
                <input type="file" name="photo"/>
            </label>
                 

            </label>
            <input type="submit" class="button" name="add" value="    add     " />  
        </div>




    </form>

</body>
</html>





