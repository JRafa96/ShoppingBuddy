<?php


$con = mysqli_connect("localhost", "root", "", "android_api");
/* check connection */
if (mysqli_connect_errno()) {
	printf("Connect failed: %s\n", mysqli_connect_error());
	exit();
}

if (isset($_POST['id'])) {
	$id = $_POST['id'];

	$id = $con->real_escape_string($id);


	$con->query("SET NAMES 'utf8'");
	$stmt = $con->prepare("SELECT id_lista,nome_lista FROM listas where id_user=?");
    $stmt->bind_param("s", $id );
    $stmt->execute();
	$stmt->bind_result($idLista, $nomeLista);


	$listas = array();

	while ($stmt->fetch()) {
		$temp = array();
		$temp['id_lista	']= $idLista ;
		$temp['nome_lista'] =$nomeLista;
		array_push($listas, $temp);
	}
	echo json_encode($listas);
	mysqli_close($con);
}
?>
