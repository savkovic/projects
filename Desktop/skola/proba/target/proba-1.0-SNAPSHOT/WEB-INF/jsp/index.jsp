<%@include file="top.jsp" %>

<div class="wrap">
	<div class="leftcol">
		

		<div class="block">
        	<div class="panel">
            	<div class="tittle">
                	<h1>Vrste automobila</h1>
                </div>
                <div class="content">
                   
                	<ul>
                     <c:forEach items="${marka}" var="marka">
                        <li><a href="./${marka.id}">${marka.ime} </a></li>
                    </c:forEach>
                	</ul>
                </div>
        	</div>
		</div>
        
        
	</div><!---leftcol--->


<div class="rightcol">
	
	<div class="page">
		<div class="panel mar-bottom">
			
            
        </div>
            <c:forEach items="${automobili}" var="automobil" varStatus="counter">
        <div class="${conter.count%2==0?"leftbox":"rightbox"}">
        	<div class="panel">
        		<img src="resorsi/images/${automobil.slika}" alt="image" width="160" height="110" />
        		<div class="title">
                	<h1>${automobil.model}</h1>
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