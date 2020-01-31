<?php 
require_once 'include/DB_Functions.php';
$db = new DB_Functions();

        $response = array("error"=>FALSE);

        if (isset($_POST['name'])) {

            $name = $_POST['name'];
        
            $listasuper = $db->getSupermercados($supermercados);
        
                echo json_encode($listasuper);
        }

?>
