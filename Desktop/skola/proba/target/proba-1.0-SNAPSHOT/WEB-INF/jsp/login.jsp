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
            <script>
            function validateLength(inputElement, min, max) {
                var inputText = inputElement.value;

                if (inputText.length < min || inputText.length > max) {
                    inputElement.style = "border-color: 2px solid red;";

                    return false;
                } else {
                    inputElement.style = "border-color: none;";

                    return true;
                }
                function validateForm() {
                var nameElement = document.forms["registerForma"]["username"];
                if (!validateLength(nameElement, 5, 20)) {
                    return false;
                }
            }
        }
    

                </script>
            
                <form action="loginn" name="registerForma"  method="post"  >
                <label> 
                    Username
                </label>
                    <input path="username" type="text" class="input_text" name="username" id="email" placeholder="Username" onchange="validateForm()" required/>
                <label>
                    Password
                </label>
                <input path="password" type="password" class="input_text" name="password" id="subject" placeholder="Password" required/>
                
                <input type="submit" class="button" name="" value="Login" />  
                <!--            <a href="register">    <input  type="submit" class="button" name="register" value="Register" />  <a/>-->
                <a href="register">   <input  type="button" class="button" value="Register" /></a>
            </form>
            
        </div>
    </body>
</html>





