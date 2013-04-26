<%-- 
    Document   : add
    Created on : Apr 9, 2013, 3:14:34 PM
    Author     : jonne
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Viitehallintajärjestelmä</title>
    </head>
    <body>
        <h1>Viitehallintajärjestelmä</h1>
        <a href="front"><< Takaisin etusivulle <<</a>
            
        <c:if test="${not empty error}">
                <p>Virhe: ${error}</p>
        </c:if>
        
        <c:choose>
            <c:when test="${type == 'Article'}">
                <h2>Lisää artikkelin viite</h2>
                <form method="POST" action="add">
                    <p>Author:<input type="text" name="author"/> Syötä ensin sukunimi, erota se etunimestä pilkulla, erota useampi kirjailija puolipisteellä, esim "Sukunimi, Matti; Sukunimi, Teppo."</p>
                    <p>Title:<input type="text" name="title"/></p>
                    <p>Journal:<input type="text" name="journal"/></p>
                    <p>Volume:<input type="text" name="volume"/></p>
                    <p>Number:<input type="text" name="number"/></p>
                    <p>Year:<input type="text" name="year"/></p>
                    <p>Pages:<input type="text" name="pages"/> Syötä sivunumerot kahdella viivalla erotettuna, esim "10--200".</p> 
                    <p>Publisher:<input type="text" name="publisher"/></p>
                    <p>Address:<input type="text" name="address"/></p>
                    <input type="hidden" name="type" value="${type}"/>
                    <input name="send" type="submit" value="Send" />

                </form>
            </c:when>
            <c:when test="${type == 'InProceedings'}">
                <h2>Lisää inproceedings viite</h2>
                <form method="POST" action="add">
                    <p>Author:<input type="text" name="author"/></p>
                    <p>Title:<input type="text" name="title"/></p>
                    <p>Series:<input type="text" name="series"/></p>
                    <p>Volume:<input type="text" name="volume"/></p>
                    <p>Edition:<input type="text" name="edition"/></p>
                    <p>Year:<input type="text" name="year"/></p>
                    <p>Month:<input type="text" name="month"/></p>
                    <p>Publisher:<input type="text" name="publisher"/></p>
                    <p>Address:<input type="text" name="address"/></p>
                    <p>Note:<input type="text" name="note"/></p>
                    <input type="hidden" name="type" value="${type}"/>
                    <input name="send" type="submit" value="Send" />

                </form>
            </c:when>
            <c:when test="${type == 'Book'}">
                <h2>Lisää kirjan viite</h2>
                <form method="POST" action="add">
                    <p>Author:<input type="text" name="author"/></p>
                    <p>Title:<input type="text" name="title"/></p>
                    <p>Book title:<input type="text" name="booktitle"/></p>
                    <p>Year:<input type="text" name="year"/></p>
                    <p>Month:<input type="text" name="month"/></p>
                    <p>Editor:<input type="text" name="editor"/></p>
                    <p>Pages:<input type="text" name="pages"/></p>
                    <p>Organisation:<input type="text" name="organisation"/></p>
                    <p>Publisher:<input type="text" name="publisher"/></p>
                    <p>Address:<input type="text" name="address"/></p>
                    <p>Note:<input type="text" name="note"/></p>
                    <input type="hidden" name="type" value="${type}"/>
                    <input name="send" type="submit" value="Send" />

                </form>
            </c:when>
        </c:choose>
    </body>
</html>
