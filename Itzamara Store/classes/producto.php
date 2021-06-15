<?php

class producto
{
    public $usuario;
    public $clave;
    public $servidor;
    public $nombreBD;

    public $conexion;

    public function __construct()
    {
        $this->usuario = 'root';
        $this->clave = 'root';
        $this->servidor = 'localhost';
        $this->nombreBD = 'ItzamaraStore';       
    }

    public function obtenerConexion()
    {
        $this->conexion = null;
        try {
            $this->conexion = new PDO("mysql:host=" . $this->servidor. ";dbname=" . $this->nombreBD, $this->usuario, $this->clave);
            $this->conexion->exec("set names uft8");
            return $this->conexion;
        } catch (PDOException $exception) {
            echo "Error de conexión: " . $exception->getMessage();
        }
    }

    public function create($sql)
    {
        $this->conexion->query('SET CHARACTER SET utf8');
        $consulta = $this->conexion->prepare($sql);
        $count = $this->conexion->exec($sql);
        return $count > 0 ?  true :  false;
    }
}
?>