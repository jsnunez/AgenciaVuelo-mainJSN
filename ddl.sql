

CREATE TABLE paises (
    id VARCHAR(5) PRIMARY KEY,
    nombre VARCHAR(30)

);



CREATE TABLE ciudades (
    id VARCHAR(5)PRIMARY KEY,
    nombre VARCHAR(50),
    idpaises VARCHAR(5),
    FOREIGN KEY (idpaises) REFERENCES paises(id)
);

CREATE TABLE aeropuertos (
     id VARCHAR(5) PRIMARY KEY,
    nombre VARCHAR(50),
    idciudad VARCHAR(5),
    FOREIGN KEY (idciudad) REFERENCES ciudades(id)
);



CREATE TABLE puertas (
     id INT AUTO_INCREMENT PRIMARY KEY,
    numeropuerta VARCHAR(10),
    idaeropuerto VARCHAR(5),
    FOREIGN KEY (idaeropuerto) REFERENCES aeropuertos(id)
);



CREATE TABLE fabricantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45)
);


CREATE TABLE modelos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30),
    idfabricante INT,
    FOREIGN KEY (idfabricante) REFERENCES fabricantes(id)
);


CREATE TABLE estados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30)   
);


CREATE TABLE tiposdocumentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45)
);

CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45)
);

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20),
    edad INT,
    idtipodocumento INT,
    numerodocumento VARCHAR(30),
    rol int,
    password VARCHAR(50),
    FOREIGN KEY (idtipodocumento) REFERENCES tiposdocumentos(id),
    FOREIGN KEY (rol) REFERENCES roles(id)
);





CREATE TABLE tarifasvuelos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(20),
    detalles TEXT,
    valor DOUBLE(7,3)
);








CREATE TABLE viajes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    fechaviaje DATE,
    precioviaje DOUBLE,
    idorigenaeropuerto VARCHAR(5),
    iddestionaeropuerto VARCHAR(5),
        FOREIGN KEY (idorigenaeropuerto) REFERENCES aeropuertos(id),
        FOREIGN KEY (iddestionaeropuerto) REFERENCES aeropuertos(id)
    );

CREATE TABLE reservaviaje (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    idvuelos INT,
    idclientes INT,
    estado VARCHAR(30),
    FOREIGN KEY (idvuelos) REFERENCES viajes(id),
    FOREIGN KEY (idclientes) REFERENCES clientes(id)

);


CREATE TABLE detallesreservaviaje (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idreserva INT,
    idpasajero INT,
    idtarifa INT,
    FOREIGN KEY (idreserva) REFERENCES reservaviaje(id),
    FOREIGN KEY (idpasajero) REFERENCES clientes(id),
    FOREIGN KEY (idtarifa) REFERENCES tarifasvuelos(id)

);


CREATE TABLE asientos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numeroasiento INT
  
);



CREATE TABLE aerolineas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30)
);



CREATE TABLE puestostripulacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40)
);



CREATE TABLE empleados (
    id INT PRIMARY KEY,
    nombre VARCHAR(40), 
    idtipodocumento INT,
    numerodocumento VARCHAR(30),
    fechaingreso DATE,
    idpuesto INT,
    idaerolinea INT,
    idaeropuerto VARCHAR(5),
    password VARCHAR(50),
    idrol INT,
    FOREIGN KEY (idpuesto) REFERENCES puestostripulacion(id),
    FOREIGN KEY (idaeropuerto) REFERENCES aeropuertos(id),
    FOREIGN KEY (idaerolinea) REFERENCES aerolineas(id),
     FOREIGN KEY (idrol) REFERENCES roles(id),
        FOREIGN KEY (idtipodocumento) REFERENCES tiposdocumentos(id)
);






CREATE TABLE aviones (
    id INT AUTO_INCREMENT ,
    matricula VARCHAR(30) UNIQUE,
    capacidad INT,
    fechafabricacion DATE,
    idestado INT,
    idmodelo INT,
    idaerolinea INT,
    PRIMARY KEY (id),
    FOREIGN KEY (idestado) REFERENCES estados(id),
    FOREIGN KEY (idmodelo) REFERENCES modelos(id),
    FOREIGN KEY (idaerolinea) REFERENCES aerolineas(id)

);




CREATE TABLE revisiones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecharevision DATE,
    idavion INT,
    FOREIGN KEY (idavion) REFERENCES aviones(id)
);


CREATE TABLE revisiondetalles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idrevision INT,
    descripcion TEXT,
    idempleado INT,
    FOREIGN KEY (idrevision) REFERENCES revisiones(id),
    FOREIGN KEY (idempleado) REFERENCES empleados(id)
);








CREATE TABLE conexionesvuelos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numeroconexion VARCHAR(20),
    idviaje INT,
    idavion INT,
    salidaidaeropuerto VARCHAR(5),
    llegadaidaeropuerto VARCHAR(5),
    FOREIGN KEY (idviaje) REFERENCES viajes(id),
    FOREIGN KEY (idavion) REFERENCES aviones(id),
    FOREIGN KEY (salidaidaeropuerto) REFERENCES aeropuertos(id),
    FOREIGN KEY (llegadaidaeropuerto) REFERENCES aeropuertos(id)

);


CREATE TABLE tripulantes (
    idempleado INT,
    idconexion INT,
    PRIMARY KEY (idempleado, idconexion),
    FOREIGN KEY (idempleado) REFERENCES empleados(id),
    FOREIGN KEY (idconexion) REFERENCES conexionesvuelos(id)
);




CREATE TABLE asientodetallereservaviajeconexion (
    idconexionvuelos INT,
    iddetallereserva INT,
    idasientos INT,    
    PRIMARY KEY (idconexionvuelos, iddetallereserva),    
    FOREIGN KEY (idconexionvuelos) REFERENCES conexionesvuelos(id),
    FOREIGN KEY (iddetallereserva) REFERENCES detallesreservaviaje(id),
    FOREIGN KEY (idasientos) REFERENCES asientos(id)
);






