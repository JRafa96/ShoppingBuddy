<?php 
require_once 'include/DB_Functions.php';
$db = new DB_Functions();

        $response = array("error"=>FALSE);

        if (isset($_POST['id_user'])) {

            $id_user = $_POST['id_user'];
        
            $listalistas = $db->getLista($lista);
        
                echo json_encode($listalistas);
        }

?>
