<?php
$con = mysqli_connect("localhost", "root", "", "android_api");

if (mysqli_connect_errno($con)) {
    echo "Falha ao conectar: " . mysqli_connect_error();
    die();
}

if (isset($_GET['tipo'])) {
    $tipo = $_GET['tipo'];


    $stmt = $con->prepare("SELECT * FROM precoscombustivel where tipo= '$tipo'");
    $stmt->execute();
    $stmt->bind_result($id, $postoId, $tipoC, $preco);

    $precos = array();

    while ($stmt->fetch()) {
        $temp = array();
        $temp['id'] = $id;
        $temp['postoId'] = $postoId;
        $temp['tipo'] = $tipoC;
        array_push($precos, $temp);
    }

    echo json_encode($precos);
    mysqli_close($con);
}

if (isset($_GET['postoId'])) {
    $postoId = $_GET['postoId'];
    $result = mysqli_query($con, "SELECT * FROM postoscombustivel where id= $postoId");
    $data = mysqli_fetch_object($result);
    echo json_encode($data);
    mysqli_close($con);
}
