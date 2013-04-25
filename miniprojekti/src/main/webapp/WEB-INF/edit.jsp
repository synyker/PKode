<%-- 
    Document   : edit
    Created on : Apr 19, 2013, 12:52:53 AM
    Author     : krista
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
        <c:choose>
            <c:when test="${reference.type == 'Article'}">
                <h2>Muokkaa artikkelin viitettä</h2>
                <form method="POST" action="edit">
                    <p>Author:<input type="text" name="author" value="${reference.author}"/> Syötä ensin sukunimi, erota se etunimestä pilkulla, erota useampi kirjailija puolipisteellä, esim "Sukunimi, Matti; Sukunimi, Teppo."</p>
                    <p>Title:<input type="text" name="title" value="${reference.title}" /></p>
                    <p>Journal:<input type="text" name="journal" value="${reference.journal}"/></p>
                    <p>Volume:<input type="text" name="volume" value="${reference.volume}"/></p>
                    <p>Number:<input type="text" name="number" value="${reference.number}"/></p>
                    <p>Year:<input type="text" name="year" value="${reference.year}"/></p>
                    <p>Pages:<input type="text" name="pages" value="${reference.pages}"/> Syötä sivunumerot kahdella viivalla erotettuna, esim "10--200".</p> 
                    <p>Publisher:<input type="text" name="publisher" value="${reference.publisher}"/></p>
                    <p>Address:<input type="text" name="address" value="${reference.address}"/></p>
                    <input type="hidden" name="type" value="${reference.type}"/>
                    <input type="hidden" name="id" value="${reference.id}"/>
                    <input name="send" type="submit" value="Send" />

                </form>
            </c:when>
            <c:when test="${type == 'InProceedings'}">
                <h2>Muokkaa inproceedings viitettä</h2>
                <form method="POST" action="edit">
                    <p>Author:<input type="text" name="author"value="${reference.author}"/></p>
                    <p>Title:<input type="text" name="title" value="${reference.title}"/></p>
                    <p>Series:<input type="text" name="series" value="${reference.series}"/></p>
                    <p>Volume:<input type="text" name="volume" value="${reference.volume}"/></p>
                    <p>Edition:<input type="text" name="edition" value="${reference.edition}"/></p>
                    <p>Year:<input type="text" name="year" value="${reference.year}"/></p>
                    <p>Month:<input type="text" name="month" value="${reference.month}"/></p>
                    <p>Publisher:<input type="text" name="publisher" value="${reference.publisher}"/></p>
                    <p>Address:<input type="text" name="address" value="${reference.address}"/></p>
                    <p>Note:<input type="text" name="note" value="${reference.note}"/></p>
                    <input type="hidden" name="type" value="${reference.type}"/>
                    <input type="hidden" name="id" value="${reference.id}"/>
                    <input name="send" type="submit" value="Send" />

                </form>
            </c:when>
            <c:when test="${reference.type == 'Book'}">
                <h2>Muokkaa kirja viitettä</h2>
                <form method="POST" action="edit">
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
                    <input type="hidden" name="type" value="${reference.type}"/>
                    <input type="hidden" name="id" value="${reference.id}"/>
                    <input name="send" type="submit" value="Send" />

                </form>
            </c:when>
        </c:choose>
    </body>
</html>
