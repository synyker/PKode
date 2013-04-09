<?php

 $host=":/home/macjantu/mysql/socket"; 
$username="root"; 
$password="Nathala739";
$db_name="pkode"; 
$tbl_name1="source"; 
//$tbl_name2="hinnat";


 mysql_connect("$host", "$username", "$password")or die("Yhdistäminen kusee"); 
 mysql_select_db("$db_name")or die("Tietokantaa ei voitu valita");

 
 $bname=$_POST['bname'];
 $wname=$_POST['wname'];
 $date=$_POST['date'];
 
$bname = stripslashes($bname);
$wname = stripslashes($wname);
$date = stripslashes($date);

$bname = mysql_real_escape_string($bname);
$wname = mysql_real_escape_string($wname);
$date = mysql_real_escape_string($date);

if($bname == "" || $wname == "" || $date == "") {
    echo "Tietoja puuttuu";
    echo "<BR>";
    echo "<a href='index.php'>Takaisin</a>";
} else {
 
 $sql1="INSERT INTO $tbl_name1(bname, wname, date)VALUES('$bname', '$wname', '$date')";
 $result1=mysql_query($sql1);

 if($result1){
 echo "Lähde lisätty onnistuneesti";
 echo "<BR>";
 echo "<a href='index.php'>Takaisin</a>";
 }
 
 else {
 echo "ERROR";
 echo "<a href='index.php'>Takaisin</a>";
 }
}

 mysql_close();
 ?>