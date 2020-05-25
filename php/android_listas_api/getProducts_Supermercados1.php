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


    $stmt = $con->prepare("SELECT id_products,quantidade FROM listas_produtos WHERE id_lista = :id");
    $stmt->bindParam(":id",$id);
    $stmt->execute();
    $resultado=$stmt->fetchAll();
   // $stmt->bind_result($idSupermercado, $somaPrice,$distancia);

  $somaSuper1=0;
  $somaSuper2=0;
  $somaSuper3=0;
  $somaSuper4=0;
  $somaSuper5=0;

  $Super1=1;
  $Super2=2;
  $Super3=3;
  $Super4=4;
  $Super5=5;

  foreach ($resultado as $row) {
  //($row=$stmt->fetch(PDO::FETCH_ASSOC)) {
      $stmt2 = $con->prepare("SELECT id_Supermercados, price FROM products_supermercados WHERE id_Produtos = :id");
      $id_prod=$row["id_products"];
      $stmt2->bindParam(":id", $id_prod);
      $stmt2->execute();
      $stmt2Res = $stmt2->fetchAll();
      foreach ($stmt2Res as $Res) {
        if ($Res["id_Supermercados"] == 1 ) {
          $somaSuper1+= $Res["price"]*$row['quantidade'];
        } else if ($Res["id_Supermercados"] == 2 ) {
          $somaSuper2+= $Res["price"]*$row['quantidade'];
        }   if ($Res["id_Supermercados"] == 3 ) {
          $somaSuper3+= $Res["price"]*$row['quantidade'];
        } else  if ($Res["id_Supermercados"] == 4 ) {
          $somaSuper4+= $Res["price"]*$row['quantidade'];
        }else  if ($Res["id_Supermercados"] == 5 ) {
          $somaSuper5+= $Res["price"]*$row['quantidade'];
        }
      }
  }

    $stmt2 = $con->prepare("SELECT id, latitude, longitude FROM supermercados ORDER BY id ASC");
    $stmt2->execute();
    $stmt2Res = $stmt2->fetchAll();
    $distancia1= $stmt2Res[0]["latitude"].", ".$stmt2Res[0]["longitude"];
    $distancia2= $stmt2Res[1]["latitude"].", ".$stmt2Res[1]["longitude"];
    $distancia3= $stmt2Res[2]["latitude"].", ".$stmt2Res[2]["longitude"];
    $distancia4= $stmt2Res[3]["latitude"].", ".$stmt2Res[3]["longitude"];
    $distancia5= $stmt2Res[4]["latitude"].", ".$stmt2Res[4]["longitude"];

   

    $temp = array();
    $temp['id_Supermercados'] = $Super1;
    $temp['id_Supermercados1'] = $Super2;
    $temp['id_Supermercados2'] = $Super3;
    $temp['id_Supermercados3'] = $Super4;
    $temp['id_Supermercados4'] = $Super5;
    $temp['price'] = $somaSuper1;
    $temp['price1'] = $somaSuper2;
    $temp['price2'] = $somaSuper3;
    $temp['price3'] = $somaSuper4;
    $temp['price4'] = $somaSuper5;
    $temp['distancia'] = $distancia1;
    $temp['distancia1'] = $distancia2;
    $temp['distancia2'] =$distancia3;
    $temp['distancia3'] =$distancia4;
    $temp['distancia4'] =$distancia5;

   // array_push($products_supermercados, $temp);

    echo json_encode($temp);
    //mysqli_close($con);
}