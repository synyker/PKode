<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>





        <form name="form1" method="post" action="insert.php">
            <table>
                <tr>
                    <td><strong>Lisää viite tietokantaan </strong></td>
                </tr>
                <tr>
                    <td>Kirjan nimi</td>
                    <td>:</td>
                    <td><input name="bname" type="text" id="name"></td>
                </tr>
                <tr>
                    <td>Kirjoittaja</td>
                    <td>:</td>
                    <td><input name="wname" type="text" id="writer"></td>
                </tr>
                <tr>
                    <td>Päivämäärä</td>
                    <td>:</td>
                    <td><input name="date" type="text" id="date"></td>
                <tr>
                    <td><input type="submit" name="Submit" value="Lisää" /></td>
                </tr>
            </table>
        </form>
        <form name="form2" method="post" action="list.php">
        <td><input type="submit" name="listaa" value="Listaa" /></td>
        </form>

        <table>
            <tr>

            </tr>
        </table>




    </body>
</html>
