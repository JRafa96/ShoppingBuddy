<?php
$con = mysqli_connect("localhost", "root", "", "android_api");

if (mysqli_connect_errno($con)) {
    echo "Falha ao conectar: " . mysqli_connect_error();
    die();
}

if (isset($_GET['id'])) {
    $id = $_GET['id'];

    $id = $con->real_escape_string($id);




    $stmt = $con->prepare("SELECT * FROM lista_produtos where id= '$id'");
    $stmt->execute();
    $stmt->bind_result($idLista, $idLista);

    $listas = array();

    while ($stmt->fetch()) {
        $temp = array();
        $temp['idLista'] = $idLista;
        $temp['idProdutos'] = $idProdutos;
        $temp['price'] = $price;
        array_push($listas, $temp);
    }
    echo json_encode($listas);
    mysqli_close($con);
}

