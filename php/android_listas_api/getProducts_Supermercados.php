<?php
$con = mysqli_connect("localhost", "root", "", "android_api");

if (mysqli_connect_errno($con)) {
    echo "Falha ao conectar: " . mysqli_connect_error();
    die();
}

if (isset($_GET['id'])) {
    $id = $_GET['id'];

    $id = $con->real_escape_string($id);




    $stmt = $con->prepare("SELECT "supermercado,sum(price),distância FROM Products_Supermercados where id_lista= '$id'");
    $stmt->execute();
    $stmt->bind_result($idSupermercado, $somaPrice,$distancia);

    $listas = array();

    while ($stmt->fetch()) {
        $temp = array();
        $temp['idLista'] = $idLista;
        $temp['idUser'] = $idUser;
        array_push($listas, $temp);
    }
    echo json_encode($products_Supermercados);
    mysqli_close($con);
}