<%@include file="top.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
         <div class="contact-form mar-top30">
     
    


<a href="admin/markaadd">   <input  type="button" class="button" value="Add" /></a>
<a href="admin/markadelete">   <input  type="button" class="button" value="Delete" /></a>
     
     
            <label> <span>Marka</span>
                <form action="admin/updatemarka" method="post" />
                    <select onchange="if(this.value!=-1) window.location='admin/marka?id='+this.value" name="id" class="input_text">
                <option value="-1">Izaberi Marku</option>  
                <c:forEach items="${marka}" var="marka">
                    <option <c:if test="${marka.id==selectedMarka.id}">selected</c:if> value="${marka.id}">${marka.ime}</option>    
                </c:forEach>
            </select>

            </label>
            <label> <span>Ime</span>
                <input type="text" class="input_text" name="ime" id="email" value="${selectedMarka.ime}" required/>
            </label>
            <label> <span>Opis</span>
                <input type="text" class="input_text" name="opis" id="subject" value="${selectedMarka.opis}"/>
            </label>
            
           
             <input type="submit" class="button" name="update" value="update" />  
             
           
             
            
          </div>
        
       
                
            
        </form>
        
    </body>
</html>
