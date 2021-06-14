CREATE DATABASE ItzamaraStore;
USE ItzamaraStore;
CREATE TABLE cliente( 
	nombre VARCHAR(100) DEFAULT "",
    paterno VARCHAR(60) DEFAULT "",
    materno VARCHAR(60) DEFAULT "",
    correo VARCHAR(70) NOT NULL PRIMARY KEY ,
    telefono VARCHAR(10),
    clave VARBINARY(100) NOT NULL 
);




USE `itzamarastore`;
DROP procedure IF EXISTS `sp_insert_cliente`;

DELIMITER $$
USE `itzamarastore`$$
CREATE PROCEDURE `sp_insert_cliente` (
	IN nombre VARCHAR(100),
    IN paterno VARCHAR(60),
    IN materno VARCHAR(60),
    IN correo VARCHAR(70),
    IN telefono VARCHAR(10),
    IN clave VARCHAR(100)
)
BEGIN
	INSERT INTO cliente (nombre, paterno, materno, correo, telefono, clave )
	VALUES 
	(nombre, paterno, materno, correo, telefono, aes_encrypt(clave,'ItzamaraPass'));
END$$

DELIMITER ;







INSERT INTO cliente (nombre, paterno, materno, correo, telefono, clave )
VALUES 
('Joana', 'Zambrano', 'Torres', 'joana@gmail.com', '5514857852', aes_encrypt('Joanita','ItzamaraPass')),
('Valeria', 'Pastrana', 'Guzman', 'vale@gmail.com', '5698653214', aes_encrypt('Miri','ItzamaraPass'));







USE `itzamarastore`;
DROP procedure IF EXISTS `sp_autentica`;

DELIMITER $$
USE `itzamarastore`$$
CREATE PROCEDURE `sp_autentica` (
	IN _correo VARCHAR(70),
    IN _clave VARCHAR(100)
)
BEGIN
	DECLARE clave_correcta VARCHAR(100);
    
    IF (SELECT COUNT(*) FROM cliente WHERE correo = _correo) = 0 THEN 
		SELECT false as respuesta, "El usuaio no existe" as mensaje;
	ELSE 
		SELECT aes_decrypt( clave, 'ItzamaraPass' ) INTO clave_correcta
		FROM cliente WHERE correo = _correo;
		
		IF clave_correcta = _clave THEN 
			SELECT 	true as respuesta, "Inicio exitoso" as mensaje;
		ELSE 
			SELECT false as respuesta, "Contraseña incorrecta" as mensaje; 
		END IF;
   END IF;     
END$$

DELIMITER ;