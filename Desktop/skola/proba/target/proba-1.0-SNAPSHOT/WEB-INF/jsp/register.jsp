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
                <form action="login" name="registerForma"  method="post" />
            </label>
            <label> <span>Username</span>
                <input path="username" type="text" class="input_text" name="username" id="email" placeholder="Username" required/>
            </label>
            
            <label> <span>Password</span>
                <input path="password" type="password" class="input_text" name="password" id="subject" placeholder="Password" required/>
            </label>
            
                 
                 
               
                
              
                 

            </label>
            <input type="submit" class="button" name="" value="Ok" />  
             
        </div>




    </form>

</body>
</html>





