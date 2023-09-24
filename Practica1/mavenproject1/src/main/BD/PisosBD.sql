
--RESET
DROP TABLE IF EXISTS FOTOS;
DROP TABLE IF EXISTS ALQUILER;

DROP TABLE IF EXISTS LIKES;

DROP TABLE IF EXISTS PISOS;
DROP TABLE IF EXISTS USUARIOS;



--CREACION DE LAS TABLAS 
CREATE TABLE USUARIOS(
    Nombre VARCHAR(255) NOT NULL,
    Apellidos VARCHAR(255) NOT NULL,
    Telefono VARCHAR(20) NOT NULL,
    Usuario VARCHAR(255) NOT NULL,
    Contrasenna VARCHAR(255) NOT NULL,
    Foto VARCHAR(255) NOT NULL,
    Administracion TINYINT(1),
    Estudiante TINYINT(1),
    Anunciante TINYINT(1),
    PRIMARY KEY(Usuario)    
   
    
    /*CHECK (Administracion = 0 OR (Administracion = 1 AND (SELECT COUNT(*) FROM USUARIO WHERE Administracion = 1) <= 1))*/
);

CREATE TABLE PISOS(
    id_Piso INT AUTO_INCREMENT,
    Calle VARCHAR(255)NOT NULL,
    Ciudad VARCHAR(255) NOT NULL,
    numHab SMALLINT NOT NULL,
    Pais VARCHAR(255) NOT NULL,
    Superficie SMALLINT NOT NULL,
    numBa SMALLINT NOT NULL,
    Piso SMALLINT NOT NULL,
    Ascensor TINYINT(1) NOT NULL,
    Mascotas TINYINT(1) NOT NULL,
    Fumar TINYINT(1) NOT NULL,
    Calefaccion TINYINT(1) NOT NULL,
    Internet TINYINT(1) NOT NULL,
    Parking TINYINT(1) NOT NULL,
    Fotos VARCHAR(255) NOT NULL,
    Precio FLOAT NOT NULL,
    Descripcion VARCHAR(255) NOT NULL,
    Anunciante VARCHAR(255),
    Compartido TINYINT(1) NOT NULL,
    PRIMARY KEY (id_Piso),
    FOREIGN KEY(Anunciante) REFERENCES USUARIOS(Usuario)
    
);

CREATE TABLE LIKES(
    Usuario VARCHAR(50)NOT NULL,
    id_Piso INT NOT NULL,
    PRIMARY KEY (Usuario,id_Piso),
    FOREIGN KEY (Usuario) REFERENCES USUARIOS(Usuario),
    FOREIGN KEY (id_Piso) REFERENCES PISOS(id_Piso)
);

CREATE TABLE ALQUILER(
    Fecha_Fin DATE NOT NULL,
    Valoracion FLOAT,
    Comentario VARCHAR(1024),
    Alquilado VARCHAR(255) NOT NULL,
    id_Piso INT NOT NULL,
    PRIMARY KEY(Fecha_Fin,Alquilado,id_Piso),
    FOREIGN KEY(Alquilado) REFERENCES USUARIOS(Usuario),
    FOREIGN KEY(id_Piso) REFERENCES PISOS(id_Piso)  
);

CREATE TABLE FOTOS(
    id_Foto INT AUTO_INCREMENT,
    Nombre VARCHAR(255) NOT NULL,
    Usuario VARCHAR(255)NOT NULL,
    id_Piso INT NOT NULL,
    imagen LONGBLOB NOT NULL,
    PRIMARY KEY(id_Foto,Nombre,Usuario,id_Piso),
    FOREIGN KEY(Usuario) REFERENCES USUARIOS(Usuario),
    FOREIGN KEY(id_Piso) REFERENCES PISOS(id_Piso) 
);


--EL ADMINISTRADOR DEL SISTEMA
INSERT INTO USUARIOS (Nombre, Apellidos, Telefono, Usuario, Contrasenna, Foto, Administracion, Estudiante, Anunciante)
VALUES ('Juan', 'Pérez Gómez', '555123456', 'admin1', 'micontrasenna', 'fotoADMIN.jpg', 1, 0, 0);

--Anunciante del piso alquilado
INSERT INTO USUARIOS (Nombre, Apellidos, Telefono, Usuario, Contrasenna, Foto, Administracion, Estudiante, Anunciante) 
VALUES ('María', 'Gómez', '555-123-4567', 'mariagomez', 'contraseña', 'foto.jpg', 0, 0, 1);

--Un usuario al que le gusta un piso
INSERT INTO USUARIOS (Nombre, Apellidos, Telefono, Usuario, Contrasenna, Foto, Administracion, Estudiante, Anunciante) 
VALUES ('Jose', 'Pérez', '555-123-4567', 'joseperez', 'contraseña', 'foto.jpg', 0, 0, 1);

INSERT INTO USUARIOS (Nombre, Apellidos, Telefono, Usuario, Contrasenna, Foto, Administracion, Estudiante, Anunciante) 
VALUES ('Pedro', 'Martínez', '555-234-5678', 'pedromartinez', 'contraseña', 'foto.jpg', 0, 1, 0);

INSERT INTO PISOS (Calle, Ciudad, numHab, Pais, Superficie, numBa, Piso, Ascensor, Mascotas, Fumar, Calefaccion, Internet, Parking, Fotos, Precio, Descripcion, Anunciante,Compartido) 
VALUES ('Calle Gran Vía 200', 'Madrid', 2, 'España', 60, 1, 3, 1, 0, 0, 1, 1, 0, 'foto1.jpg,foto2.jpg', 800, 'Apartamento en el centro de la ciudad', 'joseperez',0);

INSERT INTO PISOS (Calle, Ciudad, numHab, Pais, Superficie, numBa, Piso, Ascensor, Mascotas, Fumar, Calefaccion, Internet, Parking, Fotos, Precio, Descripcion, Anunciante,Compartido) 
VALUES ('Calle Falsa 123', 'Madrid', 3, 'España', 60, 1, 1, 1, 0, 0, 1, 1, 0, 'foto1.jpg,foto2.jpg,foto3.jpg', 800, 'Piso acogedor en el centro', 'mariagomez',1);



