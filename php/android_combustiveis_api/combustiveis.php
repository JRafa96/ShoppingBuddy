<?php
$con = mysqli_connect("localhost", "root", "", "android_api");

if (mysqli_connect_errno($con)) {
    echo "Falha ao conectar: " . mysqli_connect_error();
}

if (isset($_GET['tipo'])) {

    $tipo = $_GET['tipo'];
    $result = mysqli_query($con, "SELECT * FROM precoscombustivel where tipo= '$tipo'");
    $data = mysqli_fetch_all($result);
    echo json_encode($data);
    mysqli_close($con);
}

if (isset($_GET['postoId'])) {

    $postoId = $_GET['postoId'];
    $result = mysqli_query($con, "SELECT * FROM postoscombustivel where id= $postoId");
    $data = mysqli_fetch_object($result);
    echo json_encode($data);
    mysqli_close($con);
}
