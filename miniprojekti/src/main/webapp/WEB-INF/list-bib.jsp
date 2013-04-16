<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%-- 
    Document   : list-bib
    Created on : Apr 9, 2013, 5:08:59 PM
    Author     : jonne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/styles.css" type="text/css" />      
        <title>Artikkeleiden listaus BibTex-muodossa</title>
    </head>
    <body>
        <a href="front"><< Takaisin etusivulle <<</a>
        <h1>Artikkeleiden listaus BibTex-muodossa</h1>
        
            <c:forEach var="reference" items="${list}">      
                <p>@${reference.type}{${reference.textid},</p>
                
                <c:if test="${not empty reference.author}">
                    <p>author = {${reference.author}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.title}">
                    <p>title = {${reference.title}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.journal}">
                    <p>journal = {${reference.journal}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.volume}">
                    <p>volume = {${reference.volume}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.number}">
                    <p>number = {${reference.number}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.year}">
                    <p>year = {${reference.year}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.month}">
                    <p>month = {${reference.month}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.pages}">
                    <p>pages = {${reference.pages}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.publisher}">
                    <p>publisher = {${reference.publisher}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.address}">
                    <p>address = {${reference.address}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.series}">
                    <p>series = {${reference.series}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.edition}">
                    <p>edition = {${reference.edition}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.note}">
                    <p>note = {${reference.note}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.editor}">
                    <p>editor = {${reference.editor}},</p>
                </c:if>
                    
                <c:if test="${not empty reference.organisation}">
                    <p>organisation = {${reference.organisation}},</p>
                </c:if>
                    
                <p>}</p>
                <br>
            </c:forEach>
    </body>
</html>
