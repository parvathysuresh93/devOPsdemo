<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VRMS| Kerala RT Office</title>
<style type="text/css">
.container {
  position: relative;
  text-align: center;
  color: white;
 }
 .centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 24px;
}
#footer{
	position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
}
#tableRto
{
	 position:fixed;
    top: 50%;
    left: 50%;
    width:30em;
    height:18em;
    margin-top: -9em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em;

}


</style>
<!--  <link href="<c:url value="/resources/css/templatemo_style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jquery.ennui.contentslider.css"/>" rel="stylesheet">-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery.ennui.contentslider.css" media="screen,projection"> 
</head>

<body >

<div id="templatemo_site_title_bar_wrapper">
	<div id="templatemo_site_title_bar">
    	<div id="site_title">
            <h1><a href="http://localhost:8081/rtoOnlineFinal/Home.jsp">VRMS<span>Kerala RTO vehicle registration</span></a></h1>
        </div>
        
        <ul id="templatemo_menu">
            <li><a href="http://localhost:8081/rto_spring/index.jsp" ><span></span>Home</a></li>
            <li><a href="http://localhost:8081/rtoOnlineFinal/about.jsp" ><span></span>About</a></li>
            <li><a href="rtoform"><span></span>Add RTO</a></li> 
            <li><a href="http://localhost:8081/rtoOnlineFinal/Home.jsp"><span></span>Logout</a></li>
        </ul>      
	</div>     
</div> 

<div id="tableRto" align="center"> 
<h2>RTO List</h2>  
<table border="2" width="70%" cellpadding="2" >  
<tr><th>Id</th><th>Name</th><th>Posted At</th><th>Address</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="rto" items="${list}">   
   <tr>  
   <td>${rto.id}</td>  
   <td>${rto.name}</td>  
   <td>${rto.postedAt}</td>
  
   <td>${rto.address}</td>  
   <td><a href="editrto/${rto.id}">Edit</a></td>  
   <td><a href="deleterto/${rto.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table> 
 </div>    

   
<div id="footer">  
<div id="templatemo_footer_wrapper">
<div id="templatemo_footer">
  <h3 align="center">       
    	<a href="http://localhost:8081/rtoOnlineFinal/about.jsp" ><span></span>About</a> | 
        <a href="http://localhost:8081/rtoOnlineFinal/findNearestRTO.jsp"><span></span>Find Nearest RTO Office</a>  
       
   </h3>         
    
    <h5 align="center">
        Copyright © 2019 VRMS- KERALA RT OFFICE | by Kerala Vehicle Registration Authority
    </h5>
    

</div> <!-- end of footer -->
</div>
</div>
</body>
</html>        