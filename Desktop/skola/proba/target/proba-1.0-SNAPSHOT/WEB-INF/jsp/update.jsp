<%@include file="top.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="contact-form mar-top30">
        
        <form method="post" action="admin/update" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${automobil.id}"/>
            <label> 
                <span>Cena<span/> 
                    <input type="text" class="input_text" name="cena" value="${automobil.cena}"/> <br/>
                <label/>
                <label>
                <span> Model<span/>  
                    <input type="text" name="model" class="input_text" value="${automobil.model}"/> <br/>
                    <label/>
                    <label><span>opis<span/>  <input type="text" class="input_text" name="opis" value="${automobil.opis}"/> <br/><label/>
                            <label>      
          <select name="marka" class="input_text">
                <c:forEach items="${marka}" var="marka">
                    <option <c:if test="${marka.id==automobil.marka}">selected</c:if> value="${marka.id}">${marka.ime}</option>    
                </c:forEach>
            </select><br/>
            <label/>
            <input type="file" name="photo"/>
          <input type="submit" class="button" value="Update" name="update"/>
          
          
          
<!--            <textarea class="message" name="opis" value="${automobil.opis}"></textarea>-->
           
           
            
            
<!--          opis <input type="" name="opis" value="${automobil.opis}"/> <br/>-->
            
        </form>

          </div>
    </body>
</html>
