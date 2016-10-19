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
                <form action="admin/update"   method="post" enctype="multipart/form-data"/>
            </label>
            <label> <span>cena</span>
                <input type="text" class="input_text" name="cena" id="email" value="${automobil.cena}"/>
            </label>
            
            <label> <span>model</span>
                <input  type="text" class="input_text" name="model" id="subject" value="${automobil.model}"/>
            </label>
            <label> <span>opis</span>
                <input  type="text" class="input_text" name="opis" id="subject" value="${automobil.opis}"/>
            </label>
             <label> <span>marka</span>
                 
                 
                <select name="marka" class="input_text">
                <c:forEach items="${marka}" var="marka">
                    <option <c:if test="${marka.id==automobil.marka}">selected</c:if> value="${marka.id}">${marka.ime}</option>    
                </c:forEach>
            </select
                 <label> <span>slika</span>
                <input type="file" name="photo"/>
            </label>
                 

            </label>
            <input type="submit" class="button" name="Update" value="update" />  
        </div>




    </form>

</body>
</html>





