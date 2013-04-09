<%-- 
    Document   : add
    Created on : Apr 9, 2013, 3:14:34 PM
    Author     : jonne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Viitehallintajärjestelmä</title>
    </head>
    <body>
        <h1>Viitehallintajärjestelmä</h1>
        <h2>Lisää viite</h2>
        <form method="POST" action="add">
            <p>Author:<input type="text" name="author"/></p>
            <p>Title:<input type="text" name="title"/></p>
            <p>Journal:<input type="text" name="journal"/></p>
            <p>Volume:<input type="text" name="volume"/></p>
            <p>Number:<input type="text" name="number"/></p>
            <p>Year:<input type="text" name="year"/></p>
            <p>Pages:<input type="text" name="pages"/></p>
            <p>Publisher:<input type="text" name="publisher"/></p>
            <p>Address:<input type="text" name="address"/></p>
            <input name="send" type="submit" value="Send" />
            
        </form>
    </body>
</html>
