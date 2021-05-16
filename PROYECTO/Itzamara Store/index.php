<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Formulario</title>
  </head>
  <body>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="#"><span class="font-weight-bold">PHP</span>escom</a>
    </nav>
    <div class="container mt-5">
        <form action="action.php" method="POST">
            <div class="form-group">
                <label for="nombre">Nombre(s):</label>
                <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Nombre(s)">
            </div>
            <div class="form-group">
                <label for="paterno">Apellido paterno:</label>
                <input type="text" id="paterno" name="paterno" class="form-control" placeholder="Apellido paterno">
            </div>
            <div class="form-group">
                <label for="materno">Apellido materno:</label>
                <input type="text" id="materno" name="materno" class="form-control" placeholder="Apellido materno">
            </div>
            <div class="form-group">
                <label for="nacimiento">Fecha de nacimiento:</label>
                <input type="date" id="nacimiento" name="nacimiento" class="form-control">
            </div>
            <div class="form-group">
                <label for="CURP">CURP:</label>
                <input type="text" id="CURP" name="CURP" class="form-control" placeholder="CURP">
            </div>
            <div class="form-group">
              <label for="Sexo">Sexo</label>
              <select class="form-control" id="Sexo"> 
                <option value="" selected disabled>Seleccione una opcion</option>
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
              </select>
            </div>
            <div class="form-group">
              <label for="Password">Password</label>
              <input type="password" class="form-control" id="Password" placeholder="Password">
            </div>
            <div class="text-right">
                <button class="btn btn-primary">Enviar</button>
            </div>
        </form>
    </div>
    <!-- 
      Apellido Materno
      Fecha de nacimiento
      CURP
      Sexo
      Password
      https://getbootstrap.com/docs/4.0/components/forms/
           -->
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>