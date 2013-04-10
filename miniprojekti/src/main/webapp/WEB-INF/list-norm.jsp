<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : list-norm
    Created on : Apr 9, 2013, 5:09:06 PM
    Author     : jonne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello NORM!</h1>
        
        
            
                <c:forEach var="reference" items="${list}">
                    <ul>
                        <li>Author: ${reference.author}</li>
                        <li>Title: ${reference.title}</li>
                        <li>Journal: ${reference.journal}</li>
                        <li>Volume: ${reference.volume}</li>
                        <li>Number: ${reference.number}</li>
                        <li>Year: ${reference.year}</li>
                        <li>Pages: ${reference.pages}</li>
                        <li>Publisher: ${reference.publisher}</li>
                        <li>Address: ${reference.address}</li>
                    </ul>
                    <p>---------</p>
                </c:forEach>

    </body>
</html>
