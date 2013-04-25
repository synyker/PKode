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
        <title>Artikkeleiden listaus ymmärrettävässä muodossa</title>
    </head>
    <body>
        
        <a href="front"><< Takaisin etusivulle <<</a>
        <a href="list-bib" id="bib"> << Listaus Bib-Tex muodossa <<</a>
        
        <p>Hae viitteitä kirjoittajan perusteella:
            <form action="search" method="GET">
                <input type="text" id="search" name="author">
                <input name="send" type="submit" value="send"/>
            </form>
        </p>
        <h1>Artikkeleiden listaus ymmärrettävässä muodossa</h1>
        
        <c:forEach var="reference" items="${list}">

            <c:if test="${not empty reference.author}">
                <p>Author: ${reference.author}</p>
            </c:if>
            <c:if test="${not empty reference.booktitle}">
                <p>Booktitle: ${reference.booktitle}</p>
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
                
            <c:if test="${not empty reference.month}">
                <p>Month: ${reference.month}</p>
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
                
            <c:if test="${not empty reference.series}">
                <p>Series: ${reference.series}</p>
            </c:if>
                
            <c:if test="${not empty reference.edition}">
                <p>Edition ${reference.edition}</p>
            </c:if>
                
            <c:if test="${not empty reference.note}">
                <p>Note: ${reference.note}</p>
            </c:if>
                
            <c:if test="${not empty reference.editor}">
                <p>Editor: ${reference.editor}</p>
            </c:if>
                
            <c:if test="${not empty reference.organisation}">
                <p>Organisation: ${reference.organisation}</p>
            </c:if>
                
            
                <form action="delete" method="GET">
                    <input type="hidden" name="id" value="${reference.id}"/>
                    <input name="delete" type="submit" value="Delete"/>
                </form>
                <form action="edit" method="GET">
                    <input type="hidden" name="id" value="${reference.id}"/>
                    <input name="edit" type="submit" value="Edit"/>
                </form>
                <br>
                <br>
        </c:forEach>

    </body>
</html>
