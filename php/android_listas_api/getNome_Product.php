<?php

$host = 'localhost';
$db = 'android_api';
$userDB='root';
$passDB='';
$charset='utf8';
$link="mysql:host=$host;dbname=$db;charset=$charset";


$con = new PDO($link,$userDB,$passDB);


if (isset($_POST['name'])) {
    $id = $_POST['name'];
    echo $id;


$stmt = $con->prepare("SELECT * FROM products WHERE name like CONCAT('%', :name, '%')");
$stmt->bindParam("name", $id);
$stmt->execute();
echo $stmt->rowCount();
$listas_products = array();

while($row = $stmt->fetch())
{
    $temp['id_product'] = $row['id'];
    $temp['nome'] = $row['name'];


    array_push($listas_products, $temp);
}
echo json_encode($listas_products);
}
