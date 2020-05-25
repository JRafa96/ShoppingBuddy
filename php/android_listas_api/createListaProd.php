<?php

$host = 'localhost';
$db = 'android_api';
$userDB='root';
$passDB='';
$charset='utf8';
$link="mysql:host=$host;dbname=$db;charset=$charset";


$con = new PDO($link,$userDB,$passDB);


if (isset($_POST['id_lista'])) {
    $id_lista = $_POST['id_lista'];

    $array = json_decode($_POST['lista_produtos']);

    for ($i=0; $i < sizeof($array) ; $i++) { 
        $stmt = $con->prepare("INSERT INTO listas_produtos(id_lista,id_products,quantidade) values(:id_lista,:id_products,:quantidade)");
        $stmt->bindParam(":id_lista",$id_lista);
        $stmt->bindParam(":id_products",$array[$i]->id_products);
        $stmt->bindParam(":quantidade",$array[$i]->quantidades);
        $stmt->execute();
    }

}

