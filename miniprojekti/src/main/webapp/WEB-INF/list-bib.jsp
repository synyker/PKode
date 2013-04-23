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
        <h1>Viitteiden listaus BibTex-muodossa</h1>
        
        <form action="download" method="GET">
            <label>Syötä nimi tiedostolle <input type="text" id="filename" name="filename">.bib</label>
                <input id="download" name="submit" type="submit" value="Lataa"/>
        </form>
        <br>
        <br>
        <textarea rows="20" cols="100">${bibstring}</textarea>
        
    </body>
</html>
