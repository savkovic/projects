<%-- 
    Document   : ADD
    Created on : Aug 12, 2016, 1:45:26 PM
    Author     : Dusan Savkovic
--%>
<%@include file="top.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
	<div>
            <div class="rightcol">
            <c:forEach items="${automobili}" var="automobili">
		<div>
			<div class="title">
            	<h1>${automobili.model}</h1>
                
            </div>
            <div class="content mar-top"> <img src="resorsi/images/${automobili.slika}" width="200" height="200" class="float-left mar-right30"/>
          <h3>${automobili.model}</h3>
          
          <p>${automobili.opis}</p>
          <h3>CENA ${automobili.cena} e</h3>
          <div class="button">
              
              <a href="admin/automobil">   <input  type="button" class="button" value="IZMENI" /></a>
          </div>
          
        </div>
          
        </div>
        <div class="clearing"></div>
	</div><!---page--->
        </c:forEach>
</div><!---Rightcol--->

    </body>
</html>


<div class="rightcol">
	
	<div class="page">
		<div class="panel mar-bottom">
			
            
        </div>
            <c:forEach items="${automobili}" var="automobil" varStatus="counter">
        <div class="${conter.count%2==0?"leftbox":"rightbox"}">
        	<div class="panel">
        		<img src="resorsi/images/${automobil.slika}" alt="image" width="160" height="110" />
        		<div class="title">
                	<h1>BMW</h1>
                </div>
                <div class="content">
                	<p>MODEL: ${automobil.model} <br/>
					CENA : ${automobil.cena}e
					
					</p>
                    <div class="button"><a href="opis/${automobil.id}">Opis</a></div>
                </div>
        	</div>
        </div> 
            </c:forEach> 
        
            
            
        <div class="clearing"></div>
       
	</div><!---page--->
</div><!---Rightcol--->
</div>
<%@include file="down.jsp" %>