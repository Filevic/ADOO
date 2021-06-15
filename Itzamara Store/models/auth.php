<?php

    require ('../classes/cliente.php'); 
    $correo = $_POST['correo'];
    $clave = $_POST['clave'] ;

    $db = new cliente();
    $db->obtenerConexion();
    $sql = "CALL sp_autentica('$correo', '$clave')";
    $result = $db->read( $sql );

    if ($result[0]->respuesta == 1){ 
        echo "Autenticación exitosa";
        ?>
        <script>
            setTimeout( () => { window.location.replace("../index.html") }, 3000);
        </script>
        <?php
    }    
    else{
        echo "Error: " . $result[0]->mensaje;
        ?>
        <script>
            setTimeout( () => { window.location.replace("../login.html")}, 3000);
        </script>
        <?php
    }

?>