        <?php
        $host = ":/home/macjantu/mysql/socket";
        $username = "root";
        $password = "Nathala739";
        $db_name = "pkode";
        $tbl_name1 = "source";

        mysql_connect("$host", "$username", "$password") or die("cannot connect");
        mysql_select_db("$db_name") or die("cannot select DB");
        
        $SQL = "SELECT * FROM source";
        
        $rs = mysql_query($SQL);
        echo "<a href='index.php'>Takaisin</a>";
        echo "<BR>";
        while($row = mysql_fetch_array($rs)) {
            echo $row['bname'] . " " . $row['wname'] . " " . $row['date'] . "<br />";
        }
                
        ?>
