<?php
    require ('../classes/cliente.php'); 
    $nombre = $_POST['nombre'];
    $paterno = $_POST['paterno'];
    $materno = $_POST['materno'];
    $correo = $_POST['correo'];
    $telefono = $_POST['telefono'];
    $clave = $_POST['clave'];
    $query = "CALL ItzamaraStore.sp_insert_cliente('$nombre','$paterno','$materno','$correo','$telefono','$clave')";
    $db = new cliente();
    $db->obtenerConexion();
    $result = $db->create( $query); 
?>

<!doctype html>
<html lang="en">
  <head>
  <?php echo "<title> Bienvenido $nombre $paterno </title>"; ?>
  </head>
  <body>
  <?php 
        if($result){
          echo "<p>Registro éxitoso</p>";
          echo "<p>Hola $nombre Bienvenido a la familia ItzamaraStore</p>";
          ?>
            <script>
                setTimeout( () => { window.location.replace("../index.html") }, 3000);
            </script>
          <?php
        }  
        else 
          echo "<p>No se ha insertado</p>";

    ?>
  </body>
</html>