<?php
    require ('../classes/producto.php'); 
    $nombre = $_POST['nombre'];
    $marca = $_POST['marca'];
    $precio = $_POST['precio'];
    $cantidad = $_POST['cantidad'];
    $proveedor = $_POST['proveedor'];
    $codigo = $_POST['codigo'];
    $query = "CALL ItzamaraStore.sp_insert_producto('$nombre','$marca','$precio','$cantidad','$proveedor','$codigo')";
    $db = new producto();
    $db->obtenerConexion();
    $result = $db->create( $query); 
?>

<!doctype html>
<html lang="en">
  <head>
  <?php echo "<title> Nuevo producto </title>"; ?>
  </head>
  <body>
  <?php 
        if($result){
          echo "<p>Registro éxitoso</p>";
          ?>
            <script>
                setTimeout( () => { window.location.replace("../nuevoProducto.html") }, 3000);
            </script>
          <?php
        }  
        else 
          echo "<p>No se ha realizado el registro del producto</p>";
    ?>
  </body>
</html>