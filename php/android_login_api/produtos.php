<?php 
require_once 'include/DB_Functions.php';
$db = new DB_Functions();

        $response = array("error"=>FALSE);

        if (isset($_POST['name'])) {

            $name = $_POST['name'];
        
            $listaproduts = $db->getProdutos($produtos);
        
                echo json_encode($listaproduts);
        }

?>
