#Creacion de base de datos
CREATE DATABASE dbjuego;
USE dbjuego;

#Creacion de Tablas
CREATE TABLE tbl_usuario (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	edad INT NOT NULL,
	usuario VARCHAR(10) NOT NULL,
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

#Eliminar la base datos
DROP DATABASE dbjuego;