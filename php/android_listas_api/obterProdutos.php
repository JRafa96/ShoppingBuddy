<?php

$host = 'localhost';
$db = 'android_api';
$userDB='root';
$passDB='';
$charset='utf8';
$link="mysql:host=$host;dbname=$db;charset=$charset";


$con = new PDO($link,$userDB,$passDB);


$stmt = $con->prepare("SELECT * FROM products");
$stmt->execute();
$listas_products = array();
while($row = $stmt->fetch())
{
  $temp = array();
    $temp['id'] = $row['id'];
    $temp['nome'] = $row["name"];   


    array_push($listas_products, $temp);
}
echo json_encode($listas_products);

