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
        <h1>Artikkeleiden listaus ymmärrettävässä muodossa</h1>
        
        <c:forEach var="reference" items="${list}">

            <c:if test="${not empty reference.author}">
                <p>Author: ${reference.author}</p>
            </c:if>
            <c:if test="${not empty reference.title}">
                <p>Title: ${reference.title}</p>
            </c:if>
            <c:if test="${not empty reference.journal}">
                <p>Journal: ${reference.journal}</p>
            </c:if>
            <c:if test="${not empty reference.volume}">
                <p>Volume: ${reference.volume}</p>
            </c:if>
            <c:if test="${not empty reference.number}">
                <p>Number: ${reference.number}</p>
            </c:if>
            <c:if test="${not empty reference.year}">
                <p>Year: ${reference.year}</p>
            </c:if>
            <c:if test="${not empty reference.pages}">
                <p>Pages: ${reference.pages}</p>
            </c:if>
            <c:if test="${not empty reference.publisher}">
                <p>Publisher: ${reference.publisher}</p>
            </c:if>
            <c:if test="${not empty reference.address}">
                <p>Address: ${reference.address}</p>
            </c:if>

            <p>---------</p>
        </c:forEach>

    </body>
</html>
