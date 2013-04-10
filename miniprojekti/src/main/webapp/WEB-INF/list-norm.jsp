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
        
        <ol>
            <c:forEach var="reference" items="${list}">
                <li>${reference.author}</li>
                <li>${reference.title}</li>
            </c:forEach>
        </ol>
    </body>
</html>
