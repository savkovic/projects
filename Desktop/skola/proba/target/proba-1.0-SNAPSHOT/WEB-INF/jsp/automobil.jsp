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
        
	<div class="rightcol">
	
	<div class="page">
		<div class="panel mar-bottom">
			
             
        </div>
            <c:forEach items="${automobil}" var="automobil" varStatus="counter">
        <div >
        	<div class="panel">
        		<img src="resorsi/images/${automobil.slika}" alt="image" width="160" height="110" />
        		<div class="title">
                	<h1>BMW</h1>
                </div>
                <div class="content">
                	<p>MODEL: ${automobil.model} <br/>
                            CENA : ${automobil.cena}e <br/>
                                        OPIS : ${automobil.opis}
					
					</p>
                                        <div class="button"><a href="admin/update?id=${automobil.id}">Izmeni</a></div>,<div class="button"><a href="admin/delete?id=${automobil.id}">Obrisi</a></div>,<div class="button"><a href="admin/add">Dodaj</a></div>
                </div>
        	</div>
        </div> 
            </c:forEach> 
        
            
            
        <div class="clearing"></div>
       
	</div><!---page--->
</div><!---Rightcol--->
</div>


    </body>
</html>


