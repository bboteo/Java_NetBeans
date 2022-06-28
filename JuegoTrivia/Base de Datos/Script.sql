#Creacion de base de datos
CREATE DATABASE dbjuego;
USE dbjuego;

#Creacion de Tablas
CREATE TABLE tbl_usuario (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	edad INT NOT NULL,
	usuario VARCHAR(10) NOT NULL UNIQUE,
	contrasena VARCHAR(50) NOT NULL,
	fk_estado_id INT NOT NULL,
	fk_tipo_usuario_id INT NOT NULL,
	fk_punteo_id INT NOT NULL UNIQUE
);

CREATE TABLE tbl_tipo_usuario (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE tbl_estado (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE tbl_punteo (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	punteo INT NOT NULL
);

CREATE TABLE tbl_bitacora (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	date_inicio DATE NOT NULL,
	date_final DATE NOT NULL,
	numero_intento INT NOT NULL,
	punteo INT NOT NULL,
	fk_usuario_id INT NOT NULL,
	fk_tipo_usuario_id INT NOT NULL
);

#Creacion de Relaciones
ALTER TABLE dbjuego.tbl_usuario ADD CONSTRAINT FK1 FOREIGN KEY (fk_estado_id)
REFERENCES dbjuego.tbl_estado (id);

ALTER TABLE dbjuego.tbl_usuario ADD CONSTRAINT FK2 FOREIGN KEY (fk_tipo_usuario_id)
REFERENCES dbjuego.tbl_estado (id);

ALTER TABLE dbjuego.tbl_usuario ADD CONSTRAINT FK3 FOREIGN KEY (fk_punteo_id)
REFERENCES dbjuego.tbl_punteo (id);

ALTER TABLE dbjuego.tbl_bitacora ADD CONSTRAINT FK4 FOREIGN KEY (fk_usuario_id)
REFERENCES dbjuego.tbl_usuario (id);

ALTER TABLE dbjuego.tbl_bitacora ADD CONSTRAINT FK5 FOREIGN KEY (fk_tipo_usuario_id)
REFERENCES dbjuego.tbl_tipo_usuario (id);

#Probando las vistas y los Join
SELECT *
FROM dbjuego.tbl_usuario;

SELECT *
FROM dbjuego.tbl_tipo_usuario;

SELECT *
FROM dbjuego.tbl_estado;

SELECT *
FROM dbjuego.tbl_punteo;

SELECT *
FROM dbjuego.tbl_bitacora;

SELECT *
FROM dbjuego.tbl_usuario AS u INNER JOIN dbjuego.tbl_tipo_usuario AS tu
	ON tu.id = u.fk_tipo_usuario_id INNER JOIN dbjuego.tbl_estado AS e
	ON e.id = u.fk_estado_id INNER JOIN dbjuego.tbl_punteo AS p
	ON p.id = u.fk_punteo_id;

SELECT *
FROM dbjuego.tbl_bitacora AS b INNER JOIN dbjuego.tbl_usuario AS u
	ON u.id = b.fk_usuario_id INNER JOIN dbjuego.tbl_tipo_usuario AS tu
	ON tu.id = b.fk_tipo_usuario_id;

#Insertando datos basicos
INSERT INTO dbjuego.tbl_tipo_usuario (nombre, descripcion) VALUES
("Administrador", "Administrador del Juego"),
("Principiante", "Jugador Nivel 1"),
("Intermedio","Jugador Nivel 2"),
("Avanzado", "Jugador Nivel 3"),
("Libre", "Puede jugar todos los niveles sin restriccion");

INSERT INTO dbjuego.tbl_estado (nombre, descripcion) VALUES
("Activo","Si, puede jugar"),
("Inactivo","No, puede jugar"),
("En espera","Esperando confirmacion del Administrador"),
("Suspendido","Jugador sancionado"),
("Completado","Jugador que completo todos los niveles"); 

#Insertando un Administrador
INSERT INTO dbjuego.tbl_punteo (punteo) VALUES (0);

INSERT INTO dbjuego.tbl_usuario (nombre,apellido,edad,usuario,contrasena,fk_estado_id,fk_tipo_usuario_id,fk_punteo_id)
VALUES ("Admin","Admin",0,"admin","admin",1,1,1);

#Probando Querys del software
SELECT u.id
FROM dbjuego.tbl_usuario AS u
WHERE (u.usuario LIKE 'admin');


SELECT u.id, u.nombre, u.apellido, u.edad, 
		u.usuario, u.contrasena, 
		u.fk_estado_id, u.fk_tipo_usuario_id, u.fk_punteo_id 
FROM dbjuego.tbl_usuario AS u
WHERE u.usuario = "admin";


#Paquete: Modelo/Class: PunteoDAO/Metodo: consultarPnuevo
SELECT p.id, p.punteo 
FROM dbjuego.tbl_punteo AS p
WHERE id=(SELECT MAX(id) FROM dbjuego.tbl_punteo);

#Paquete< Modelo / Class: UsuarioDAO / Metodo: Consultar usuario
SELECT u.id, u.nombre, u.apellido, u.edad, u.usuario, u.contrasena, 
	u.fk_estado_id, u.fk_tipo_usuario_id, u.fk_punteo_id
FROM dbjuego.tbl_usuario AS u;


#Paquete: Modelo / Class:UsuarioDAO / Metodo: ActualizarU
UPDATE dbjuego.tbl_usuario AS u
SET 
u.nombre = 'Giancarlo', 
u.apellido = 'Boteo', 
u.edad = 100, 
u.usuario = 'bboteo', 
u.contrasena = '1234',
u.fk_estado_id= 1,
u.fk_tipo_usuario_id = 2,
u.fk_punteo_id = 3 
WHERE u.id = 2;

#Paquete: Modelo / Class:UsuarioDAO / Metrodo: ConsultarUjoin
SELECT u.id, u.nombre, u.apellido, u.edad, u.usuario, u.contrasena, tu.nombre, e.nombre, p.punteo
FROM dbjuego.tbl_usuario AS u INNER JOIN dbjuego.tbl_tipo_usuario AS tu
	ON tu.id = u.fk_tipo_usuario_id INNER JOIN dbjuego.tbl_estado AS e 
	ON e.id = u.fk_estado_id INNER JOIN dbjuego.tbl_punteo AS p
	ON p.id = u.fk_punteo_id;


UPDATE dbjuego.tbl_usuario AS u
SET u.fk_estado_id = 3
WHERE u.id = 3;



#Paquete: Modelo / Class:EstadoDAO / Metodo: ConsultarE
SELECT e.id, e.nombre, e.descripcion
FROM dbjuego.tbl_estado AS e
WHERE e.id = 1;

#Paquete: Modelo / Class:TipoUsuarioDAO / Metodo:ConsultarTu
SELECT tu.id, tu.nombre, tu.descripcion
FROM dbjuego.tbl_tipo_usuario AS tu

#Paquete: Modelo / Class:TipoUsuarioDAO / Metodo:ConsultarEtu
SELECT tu.id, tu.nombre, tu.descripcion 
FROM dbjuego.tbl_tipo_usuario AS tu
WHERE tu.id = 1;

#Paquete:Modelo
SELECT *
FROM dbjuego.tbl_punteo;

DELETE FROM dbjuego.tbl_punteo
WHERE id = 4;

SELECT *
FROM dbjuego.tbl_usuario;

DELETE FROM dbjuego.tbl_usuario
WHERE id = 4;

#Insertar en Bitacora
INSERT INTO dbjuego.tbl_bitacora (date_inicio, date_final, numero_intento, punteo, fk_usuario_id, fk_tipo_usuario_id)
VALUES ('2022-06-06','2022-06-06',1,6,1,1);  

SELECT b.id, b.date_inicio, b.date_final, b.numero_intento, b.punteo, b.fk_usuario_id, b.fk_tipo_usuario_id
FROM dbjuego.tbl_bitacora AS b;


#otras modificaciones
UPDATE dbjuego.tbl_punteo AS p
SET p.punteo = 10
WHERE p.id = 1;

SELECT *
FROM dbjuego.tbl_tipo_usuario;

#Eliminar la base datos
DROP DATABASE dbjuego;
