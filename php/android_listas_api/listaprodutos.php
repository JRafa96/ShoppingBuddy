<?php

$host = 'localhost';
$db = 'android_api';
$userDB='root';
$passDB='';
$charset='utf8';
$link="mysql:host=$host;dbname=$db;charset=$charset";


$con = new PDO($link,$userDB,$passDB);


if (isset($_POST['id_lista'])) {
    $id = $_POST['id_lista'];


$stmt = $con->prepare("SELECT id_products, price FROM listas_produtos WHERE id_lista = :id");
$stmt->bindParam("id", $id);
$stmt->execute();
$listas_products = array();
while($row = $stmt->fetch())
{
  $stmt2 = $con->prepare("SELECT name FROM products WHERE id = :id");
  $stmt2->bindParam("id", $row[0]);
  $stmt2->execute();
  $stmt2Res = $stmt2->fetch();
  $temp = array();
    $temp['id_product'] = $row['id_products'];
    $temp['nome'] = $stmt2Res[0];
    $temp['price'] = $row['price'];

    array_push($listas_products, $temp);
}
echo json_encode($listas_products);
}
