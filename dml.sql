-- mysql -u campus2023 -p

-- // paises:

INSERT INTO paises (id, nombre) VALUES ('ESP', 'España');
INSERT INTO paises (id, nombre) VALUES ('FRA', 'Francia');
INSERT INTO paises (id, nombre) VALUES ('USA', 'Estados Unidos');
INSERT INTO paises (id, nombre) VALUES ('GER', 'Alemania');
INSERT INTO paises (id, nombre) VALUES ('COL', 'Colombia');


--  // ciudades: 

-- Ciudades de España
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('MAD', 'Madrid', 'ESP');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('BCN', 'Barcelona', 'ESP');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('VAL', 'Valencia', 'ESP');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('SEV', 'Sevilla', 'ESP');

-- Ciudades de Francia
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('PAR', 'París', 'FRA');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('LYO', 'Lyon', 'FRA');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('MAR', 'Marsella', 'FRA');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('NIC', 'Niza', 'FRA');

-- Ciudades de Estados Unidos
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('NYC', 'Nueva York', 'USA');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('LAX', 'Los Ángeles', 'USA');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('CHI', 'Chicago', 'USA');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('MIA', 'Miami', 'USA');

-- Ciudades de Alemania
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('BER', 'Berlín', 'GER');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('MUC', 'Múnich', 'GER');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('HAM', 'Hamburgo', 'GER');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('FRA', 'Fráncfort', 'GER');

-- Ciudades de Colombia
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('BOG', 'Bogotá', 'COL');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('MED', 'Medellín', 'COL');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('CLO', 'Cali', 'COL');
INSERT INTO ciudades (id, nombre, idpaises) VALUES ('CAR', 'Cartagena', 'COL');


-- // aeropuertos: 

-- Aeropuertos de España
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('MAD1', 'Aeropuerto Adolfo Suárez Madrid-Barajas', 'MAD');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('BCN1', 'Aeropuerto de Barcelona-El Prat', 'BCN');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('VAL1', 'Aeropuerto de Valencia', 'VAL');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('SEV1', 'Aeropuerto de Sevilla', 'SEV');

-- Aeropuertos de Francia
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('PAR1', 'Aeropuerto Charles de Gaulle', 'PAR');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('PAR2', 'Aeropuerto de Orly', 'PAR');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('LYO1', 'Aeropuerto de Lyon-Saint Exupéry', 'LYO');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('MAR1', 'Aeropuerto de Marsella-Provenza', 'MAR');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('NIC1', 'Aeropuerto de Niza-Costa Azul', 'NIC');

-- Aeropuertos de Estados Unidos
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('NYC1', 'Aeropuerto Internacional John F. Kennedy', 'NYC');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('NYC2', 'Aeropuerto de LaGuardia', 'NYC');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('LAX1', 'Aeropuerto Internacional de Los Ángeles', 'LAX');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('CHI1', 'Aeropuerto Internacional Hare', 'CHI');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('MIA1', 'Aeropuerto Internacional de Miami', 'MIA');

-- Aeropuertos de Alemania
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('BER1', 'Aeropuerto de Berlín-Brandeburgo', 'BER');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('MUC1', 'Aeropuerto de Múnich-Franz Josef Strauss', 'MUC');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('HAM1', 'Aeropuerto de Hamburgo', 'HAM');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('FRA1', 'Aeropuerto de Fráncfort', 'FRA');

-- Aeropuertos de Colombia
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('BOG1', 'Aeropuerto Internacional El Dorado', 'BOG');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('MED1', 'Aeropuerto Internacional José María Córdova', 'MED');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('CLO1', 'Aeropuerto Internacional Alfonso Bonilla Aragón', 'CLO');
INSERT INTO aeropuertos (id, nombre, idciudad) VALUES ('CAR1', 'Aeropuerto Internacional Rafael Núñez', 'CAR');


-- // puertas: 

-- Puertas de Aeropuertos de España
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'MAD1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'BCN1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'VAL1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'SEV1');

-- Puertas de Aeropuertos de Francia
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'PAR1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P2', 'PAR1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P3', 'PAR1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'PAR2');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'LYO1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'MAR1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'NIC1');

-- Puertas de Aeropuertos de Estados Unidos
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'NYC1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P2', 'NYC1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'NYC2');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'LAX1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'CHI1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'MIA1');

-- Puertas de Aeropuertos de Alemania
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'BER1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'MUC1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'HAM1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'FRA1');

-- Puertas de Aeropuertos de Colombia
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'BOG1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P2', 'BOG1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P3', 'BOG1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'MED1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'CLO1');
INSERT INTO puertas (numeropuerta, idaeropuerto) VALUES ('P1', 'CAR1');


-- // fabricantes: 

INSERT INTO fabricantes (nombre) VALUES ('Airbus');
INSERT INTO fabricantes (nombre) VALUES ('Boeing');
INSERT INTO fabricantes (nombre) VALUES ('Embraer');
INSERT INTO fabricantes (nombre) VALUES ('Bombardier');



-- // modelos: 

INSERT INTO modelos (nombre, idfabricante) VALUES ('A320', 1);
INSERT INTO modelos (nombre, idfabricante) VALUES ('A330', 1);
INSERT INTO modelos (nombre, idfabricante) VALUES ('A350', 1);

INSERT INTO modelos (nombre, idfabricante) VALUES ('737', 2);
INSERT INTO modelos (nombre, idfabricante) VALUES ('747', 2);
INSERT INTO modelos (nombre, idfabricante) VALUES ('787', 2);

INSERT INTO modelos (nombre, idfabricante) VALUES ('ERJ-145', 3);
INSERT INTO modelos (nombre, idfabricante) VALUES ('E-Jet E2', 3);
INSERT INTO modelos (nombre, idfabricante) VALUES ('Legacy 650', 3);

INSERT INTO modelos (nombre, idfabricante) VALUES ('CRJ700', 4);
INSERT INTO modelos (nombre, idfabricante) VALUES ('Global 7500', 4);
INSERT INTO modelos (nombre, idfabricante) VALUES ('Q400', 4);



--  // estados: Los estados de los aviones.

-- Estados de aviones

INSERT INTO estados (nombre) VALUES ('En servicio');
INSERT INTO estados (nombre) VALUES ('En mantenimiento');
INSERT INTO estados (nombre) VALUES ('Fuera de servicio');
INSERT INTO estados (nombre) VALUES ('En reparación');
INSERT INTO estados (nombre) VALUES ('En espera de revisión');
INSERT INTO estados (nombre) VALUES ('En reserva');



-- // tiposdocumentos: Los tipos de documentos que se usarán en clientes 

INSERT INTO tiposdocumentos (nombre) VALUES ('DNI');
INSERT INTO tiposdocumentos (nombre) VALUES ('Pasaporte');
INSERT INTO tiposdocumentos (nombre) VALUES ('Cédula de identidad');
INSERT INTO tiposdocumentos (nombre) VALUES ('Registro civil');
INSERT INTO tiposdocumentos (nombre) VALUES ('Tarjeta de identidad');



INSERT INTO roles (id, nombre)
VALUES (1, "cliente");
INSERT INTO roles (id, nombre)
VALUES (2, "pasajero");
INSERT INTO roles (id, nombre)
VALUES (3, "Administrador del Sistema");
INSERT INTO roles (id, nombre)
VALUES (4, "Agente de Ventas");
INSERT INTO roles (id, nombre)
VALUES (5, "Técnico de Mantenimiento");
-- // clientes: 

-- Clientes para Aerolínea 1
INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Juan Pérez', 30, 1, '12345678', 1, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('María López', 25, 2, 'AB123456', 1, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Pedro Gómez', 28, 3, 'C1234567', 1, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Ana Martínez', 35, 1, '87654321', 1, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Carlos Rodríguez', 40, 2, 'CD654321', 2, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Laura Sánchez', 32, 3, 'E7654321', 2, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Santiago Vargas', 27, 1, '98765432', 2, '123');

-- Clientes para Aerolínea 2
INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Elena Rojas', 29, 1, '23456789', 1, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Martín Soto', 31, 2, 'EF234567', 1, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Luisa Herrera', 26, 3, 'G2345678', 1, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Andrés Castro', 33, 1, '87654321', 1, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Paula Díaz', 37, 2, 'GH654321', 1, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Mario Gutiérrez', 30, 3, 'I7654321', 2, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Alejandra Ramírez', 28, 1, '98765432', 2, '123');

-- Clientes para Aerolínea 3
INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Gabriel Torres', 34, 1, '34567890', 2, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Valeria Núñez', 27, 2, 'IJ345678', 2, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Jorge Pérez', 32, 3, 'J3456789', 2, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Lucía Castro', 36, 1, '98765432', 2, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Diego Muñoz', 39, 2, 'KL654321', 1, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Carolina Jiménez', 25, 3, 'M7654321', 1, '123');

INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento, rol, password) 
VALUES ('Mateo Sánchez', 31, 1, '09876543', 1, '123');





INSERT INTO tarifasvuelos (descripcion, detalles, valor)
VALUES ('Eco Nac Estándar', 'Asiento estándar, vuelo nacional', 120.00);

INSERT INTO tarifasvuelos (descripcion, detalles, valor)
VALUES ('Eco Int Estándar', 'Asiento estándar, vuelo internacional', 200.00);

INSERT INTO tarifasvuelos (descripcion, detalles, valor)
VALUES ('Eje Nac Amplio', 'Asiento amplio, vuelo nacional', 300.00);

INSERT INTO tarifasvuelos (descripcion, detalles, valor)
VALUES ('Eje Int Amplio', 'Asiento amplio, vuelo internacional', 450.00);

INSERT INTO tarifasvuelos (descripcion, detalles, valor)
VALUES ('Prim Nac Especial', 'Asiento especial, vuelo nacional', 500.00);

INSERT INTO tarifasvuelos (descripcion, detalles, valor)
VALUES ('Prim Int Especial', 'Asiento especial, vuelo internacional', 700.00);

INSERT INTO tarifasvuelos (descripcion, detalles, valor)
VALUES ('Eco Prom Nac Est', 'Asiento estándar, vuelo nacional (promoción)', 90.00);

INSERT INTO tarifasvuelos (descripcion, detalles, valor)
VALUES ('Eco Prom Int Est', 'Asiento estándar, vuelo internacional (promoción)', 150.00);




-- Inserciones de viajes programados


-- Viajes en julio y agosto de 2024
INSERT INTO viajes (fechaviaje, precioviaje, idorigenaeropuerto, iddestionaeropuerto)
VALUES 
    ('2024-07-01', 260.00, 'NYC1', 'PAR1'),
    ('2024-07-01', 310.00, 'BCN1', 'LAX1'),
    ('2024-07-01', 280.00, 'MAD1', 'MIA1'),
    ('2024-07-02', 320.00, 'LYO1', 'NYC1'),
    ('2024-07-02', 290.00, 'SEV1', 'PAR1'),
    ('2024-07-03', 275.00, 'MAD1', 'LAX1'),
    ('2024-07-03', 305.00, 'NYC1', 'MIA1'),
    ('2024-07-04', 340.00, 'BCN1', 'PAR1'),
    ('2024-07-04', 310.00, 'LYO1', 'MIA1'),
    ('2024-07-05', 295.00, 'SEV1', 'NYC1'),
    ('2024-07-05', 315.00, 'MAD1', 'PAR1'),
    ('2024-07-06', 325.00, 'NYC1', 'LAX1'),
    ('2024-07-06', 280.00, 'BCN1', 'MIA1'),
    ('2024-07-07', 300.00, 'LYO1', 'LAX1'),
    ('2024-07-07', 290.00, 'SEV1', 'MIA1'),
    ('2024-07-08', 310.00, 'MAD1', 'NYC1'),
    ('2024-07-08', 270.00, 'NYC1', 'PAR1'),
    ('2024-07-09', 325.00, 'BCN1', 'LAX1'),
    ('2024-07-09', 310.00, 'LYO1', 'NYC1'),
    ('2024-07-10', 285.00, 'SEV1', 'LAX1'),
    ('2024-07-10', 320.00, 'MAD1', 'MIA1'),
    ('2024-07-11', 275.00, 'NYC1', 'MIA1'),
    ('2024-07-11', 315.00, 'BCN1', 'PAR1'),
    ('2024-07-12', 305.00, 'LYO1', 'LAX1'),
    ('2024-07-12', 290.00, 'SEV1', 'NYC1'),
    ('2024-07-13', 325.00, 'MAD1', 'PAR1'),
    ('2024-07-13', 270.00, 'NYC1', 'LAX1'),
    ('2024-07-14', 310.00, 'BCN1', 'MIA1'),
    ('2024-07-14', 295.00, 'LYO1', 'PAR1'),
    ('2024-07-15', 280.00, 'SEV1', 'LAX1'),
    ('2024-07-15', 320.00, 'MAD1', 'NYC1'),
    ('2024-07-16', 275.00, 'NYC1', 'PAR1'),
    ('2024-07-16', 325.00, 'BCN1', 'LAX1'),
    ('2024-07-17', 300.00, 'LYO1', 'MIA1'),
    ('2024-07-17', 290.00, 'SEV1', 'NYC1'),
    ('2024-07-18', 310.00, 'MAD1', 'PAR1'),
    ('2024-07-18', 325.00, 'NYC1', 'LAX1'),
    ('2024-07-19', 280.00, 'BCN1', 'MIA1'),
    ('2024-07-19', 300.00, 'LYO1', 'LAX1'),
    ('2024-07-20', 290.00, 'SEV1', 'MIA1'),
    ('2024-07-20', 310.00, 'MAD1', 'NYC1'),
    ('2024-07-21', 275.00, 'NYC1', 'PAR1'),
    ('2024-07-21', 325.00, 'BCN1', 'LAX1'),
    ('2024-07-22', 310.00, 'LYO1', 'MIA1'),
    ('2024-07-22', 285.00, 'SEV1', 'LAX1'),
    ('2024-07-23', 320.00, 'MAD1', 'PAR1'),
    ('2024-07-23', 275.00, 'NYC1', 'MIA1'),
    ('2024-07-24', 305.00, 'BCN1', 'LAX1'),
    ('2024-07-24', 290.00, 'LYO1', 'NYC1'),
    ('2024-07-25', 325.00, 'SEV1', 'MIA1'),
    ('2024-07-25', 270.00, 'MAD1', 'LAX1'),
    ('2024-07-26', 310.00, 'NYC1', 'PAR1'),
    ('2024-07-26', 295.00, 'BCN1', 'MIA1'),
    ('2024-07-27', 320.00, 'LYO1', 'LAX1'),
    ('2024-07-27', 285.00, 'SEV1', 'NYC1'),
    ('2024-07-28', 275.00, 'MAD1', 'MIA1'),
    ('2024-07-28', 325.00, 'NYC1', 'LAX1'),
    ('2024-07-29', 300.00, 'BCN1', 'PAR1'),
    ('2024-07-29', 290.00, 'LYO1', 'MIA1'),
    ('2024-07-30', 310.00, 'SEV1', 'LAX1'),
    ('2024-07-30', 280.00, 'MAD1', 'NYC1'),
    ('2024-07-31', 325.00, 'NYC1', 'PAR1'),
    ('2024-08-01', 310.00, 'BCN1', 'LAX1'),
    ('2024-08-01', 295.00, 'LYO1', 'MIA1'),
    ('2024-08-02', 280.00, 'SEV1', 'NYC1'),
    ('2024-08-02', 320.00, 'MAD1', 'PAR1'),
    ('2024-08-03', 325.00, 'NYC1', 'LAX1'),
    ('2024-08-03', 275.00, 'BCN1', 'MIA1'),
    ('2024-08-04', 290.00, 'LYO1', 'PAR1'),
    ('2024-08-04', 310.00, 'SEV1', 'NYC1'),
    ('2024-08-05', 275.00, 'MAD1', 'LAX1'),
    ('2024-08-05', 325.00, 'NYC1', 'MIA1'),
    ('2024-08-06', 280.00, 'BCN1', 'PAR1'),
    ('2024-08-06', 295.00, 'LYO1', 'LAX1'),
    ('2024-08-07', 310.00, 'SEV1', 'NYC1'),
    ('2024-08-07', 320.00, 'MAD1', 'MIA1'),
    ('2024-08-08', 325.00, 'NYC1', 'PAR1'),
    ('2024-08-08', 275.00, 'BCN1', 'LAX1')
;

-- Inserciones de reservas de viajes


-- // reservaviaje: Las reservas de los viajes.

-- Inserciones de reservas de viajes

INSERT INTO reservaviaje (fecha, idvuelos,idclientes,estado)
VALUES ('2024-08-10', 1,1,"pagado"); -- Reserva para el viaje programado con ID 1

INSERT INTO reservaviaje (fecha, idvuelos,idclientes,estado)
VALUES ('2024-08-18', 2,2,"pagado"); -- Reserva para el viaje programado con ID 2

INSERT INTO reservaviaje (fecha, idvuelos,idclientes,estado)
VALUES ('2024-09-02', 3,3,"pagado"); -- Reserva para el viaje programado con ID 3

INSERT INTO reservaviaje (fecha, idvuelos,idclientes,estado)
VALUES ('2024-09-08', 4,4,"pagado"); -- Reserva para el viaje programado con ID 4

INSERT INTO reservaviaje (fecha, idvuelos,idclientes,estado)
VALUES ('2024-09-25', 5,5,"pagado"); -- Reserva para el viaje programado con ID 5




INSERT INTO detallesreservaviaje (idreserva, idpasajero, idtarifa)
VALUES (1, 1, 1); -- Detalle de reserva para la reserva ID 1, cliente ID 1 y tarifa ID 1

INSERT INTO detallesreservaviaje (idreserva, idpasajero, idtarifa)
VALUES (2, 2, 2); -- Detalle de reserva para la reserva ID 2, cliente ID 2 y tarifa ID 2

INSERT INTO detallesreservaviaje (idreserva, idpasajero, idtarifa)
VALUES (3, 3, 3); -- Detalle de reserva para la reserva ID 3, cliente ID 3 y tarifa ID 3

INSERT INTO detallesreservaviaje (idreserva, idpasajero, idtarifa)
VALUES (4, 4, 4); -- Detalle de reserva para la reserva ID 4, cliente ID 4 y tarifa ID 4

INSERT INTO detallesreservaviaje (idreserva, idpasajero, idtarifa)
VALUES (5, 5, 5); -- Detalle de reserva para la reserva ID 5, cliente ID 5 y tarifa ID 5



-- Inserciones en la tabla 'asientos'

INSERT INTO asientos (numeroasiento) VALUES (1);
INSERT INTO asientos (numeroasiento) VALUES (2);
INSERT INTO asientos (numeroasiento) VALUES (3);
INSERT INTO asientos (numeroasiento) VALUES (4);
INSERT INTO asientos (numeroasiento) VALUES (5);
INSERT INTO asientos (numeroasiento) VALUES (6);
INSERT INTO asientos (numeroasiento) VALUES (7);
INSERT INTO asientos (numeroasiento) VALUES (8);
INSERT INTO asientos (numeroasiento) VALUES (9);
INSERT INTO asientos (numeroasiento) VALUES (10);
INSERT INTO asientos (numeroasiento) VALUES (11);
INSERT INTO asientos (numeroasiento) VALUES (12);
INSERT INTO asientos (numeroasiento) VALUES (13);
INSERT INTO asientos (numeroasiento) VALUES (14);
INSERT INTO asientos (numeroasiento) VALUES (15);
INSERT INTO asientos (numeroasiento) VALUES (16);
INSERT INTO asientos (numeroasiento) VALUES (17);
INSERT INTO asientos (numeroasiento) VALUES (18);
INSERT INTO asientos (numeroasiento) VALUES (19);
INSERT INTO asientos (numeroasiento) VALUES (20);
INSERT INTO asientos (numeroasiento) VALUES (21);
INSERT INTO asientos (numeroasiento) VALUES (22);
INSERT INTO asientos (numeroasiento) VALUES (23);
INSERT INTO asientos (numeroasiento) VALUES (24);
INSERT INTO asientos (numeroasiento) VALUES (25);
INSERT INTO asientos (numeroasiento) VALUES (26);
INSERT INTO asientos (numeroasiento) VALUES (27);
INSERT INTO asientos (numeroasiento) VALUES (28);
INSERT INTO asientos (numeroasiento) VALUES (29);
INSERT INTO asientos (numeroasiento) VALUES (30);
INSERT INTO asientos (numeroasiento) VALUES (31);
INSERT INTO asientos (numeroasiento) VALUES (32);
INSERT INTO asientos (numeroasiento) VALUES (33);
INSERT INTO asientos (numeroasiento) VALUES (34);
INSERT INTO asientos (numeroasiento) VALUES (35);
INSERT INTO asientos (numeroasiento) VALUES (36);
INSERT INTO asientos (numeroasiento) VALUES (37);
INSERT INTO asientos (numeroasiento) VALUES (38);
INSERT INTO asientos (numeroasiento) VALUES (39);
INSERT INTO asientos (numeroasiento) VALUES (40);
INSERT INTO asientos (numeroasiento) VALUES (41);
INSERT INTO asientos (numeroasiento) VALUES (42);
INSERT INTO asientos (numeroasiento) VALUES (43);
INSERT INTO asientos (numeroasiento) VALUES (44);
INSERT INTO asientos (numeroasiento) VALUES (45);
INSERT INTO asientos (numeroasiento) VALUES (46);
INSERT INTO asientos (numeroasiento) VALUES (47);
INSERT INTO asientos (numeroasiento) VALUES (48);
INSERT INTO asientos (numeroasiento) VALUES (49);
INSERT INTO asientos (numeroasiento) VALUES (50);
INSERT INTO asientos (numeroasiento) VALUES (51);
INSERT INTO asientos (numeroasiento) VALUES (52);
INSERT INTO asientos (numeroasiento) VALUES (53);
INSERT INTO asientos (numeroasiento) VALUES (54);
INSERT INTO asientos (numeroasiento) VALUES (55);
INSERT INTO asientos (numeroasiento) VALUES (56);
INSERT INTO asientos (numeroasiento) VALUES (57);
INSERT INTO asientos (numeroasiento) VALUES (58);
INSERT INTO asientos (numeroasiento) VALUES (59);
INSERT INTO asientos (numeroasiento) VALUES (60);
INSERT INTO asientos (numeroasiento) VALUES (61);
INSERT INTO asientos (numeroasiento) VALUES (62);
INSERT INTO asientos (numeroasiento) VALUES (63);
INSERT INTO asientos (numeroasiento) VALUES (64);
INSERT INTO asientos (numeroasiento) VALUES (65);
INSERT INTO asientos (numeroasiento) VALUES (66);
INSERT INTO asientos (numeroasiento) VALUES (67);
INSERT INTO asientos (numeroasiento) VALUES (68);
INSERT INTO asientos (numeroasiento) VALUES (69);
INSERT INTO asientos (numeroasiento) VALUES (70);
INSERT INTO asientos (numeroasiento) VALUES (71);
INSERT INTO asientos (numeroasiento) VALUES (72);
INSERT INTO asientos (numeroasiento) VALUES (73);
INSERT INTO asientos (numeroasiento) VALUES (74);
INSERT INTO asientos (numeroasiento) VALUES (75);
INSERT INTO asientos (numeroasiento) VALUES (76);
INSERT INTO asientos (numeroasiento) VALUES (77);
INSERT INTO asientos (numeroasiento) VALUES (78);
INSERT INTO asientos (numeroasiento) VALUES (79);
INSERT INTO asientos (numeroasiento) VALUES (80);
INSERT INTO asientos (numeroasiento) VALUES (81);
INSERT INTO asientos (numeroasiento) VALUES (82);
INSERT INTO asientos (numeroasiento) VALUES (83);
INSERT INTO asientos (numeroasiento) VALUES (84);
INSERT INTO asientos (numeroasiento) VALUES (85);
INSERT INTO asientos (numeroasiento) VALUES (86);
INSERT INTO asientos (numeroasiento) VALUES (87);
INSERT INTO asientos (numeroasiento) VALUES (88);
INSERT INTO asientos (numeroasiento) VALUES (89);
INSERT INTO asientos (numeroasiento) VALUES (90);
INSERT INTO asientos (numeroasiento) VALUES (91);
INSERT INTO asientos (numeroasiento) VALUES (92);
INSERT INTO asientos (numeroasiento) VALUES (93);
INSERT INTO asientos (numeroasiento) VALUES (94);
INSERT INTO asientos (numeroasiento) VALUES (95);
INSERT INTO asientos (numeroasiento) VALUES (96);
INSERT INTO asientos (numeroasiento) VALUES (97);
INSERT INTO asientos (numeroasiento) VALUES (98);
INSERT INTO asientos (numeroasiento) VALUES (99);
INSERT INTO asientos (numeroasiento) VALUES (100);
INSERT INTO asientos (numeroasiento) VALUES (101);
INSERT INTO asientos (numeroasiento) VALUES (102);
INSERT INTO asientos (numeroasiento) VALUES (103);
INSERT INTO asientos (numeroasiento) VALUES (104);
INSERT INTO asientos (numeroasiento) VALUES (105);
INSERT INTO asientos (numeroasiento) VALUES (106);
INSERT INTO asientos (numeroasiento) VALUES (107);
INSERT INTO asientos (numeroasiento) VALUES (108);
INSERT INTO asientos (numeroasiento) VALUES (109);
INSERT INTO asientos (numeroasiento) VALUES (110);
INSERT INTO asientos (numeroasiento) VALUES (111);
INSERT INTO asientos (numeroasiento) VALUES (112);
INSERT INTO asientos (numeroasiento) VALUES (113);
INSERT INTO asientos (numeroasiento) VALUES (114);
INSERT INTO asientos (numeroasiento) VALUES (115);
INSERT INTO asientos (numeroasiento) VALUES (116);
INSERT INTO asientos (numeroasiento) VALUES (117);
INSERT INTO asientos (numeroasiento) VALUES (118);
INSERT INTO asientos (numeroasiento) VALUES (119);
INSERT INTO asientos (numeroasiento) VALUES (120);
INSERT INTO asientos (numeroasiento) VALUES (121);
INSERT INTO asientos (numeroasiento) VALUES (122);
INSERT INTO asientos (numeroasiento) VALUES (123);
INSERT INTO asientos (numeroasiento) VALUES (124);
INSERT INTO asientos (numeroasiento) VALUES (125);
INSERT INTO asientos (numeroasiento) VALUES (126);
INSERT INTO asientos (numeroasiento) VALUES (127);
INSERT INTO asientos (numeroasiento) VALUES (128);
INSERT INTO asientos (numeroasiento) VALUES (129);
INSERT INTO asientos (numeroasiento) VALUES (130);
INSERT INTO asientos (numeroasiento) VALUES (131);
INSERT INTO asientos (numeroasiento) VALUES (132);
INSERT INTO asientos (numeroasiento) VALUES (133);
INSERT INTO asientos (numeroasiento) VALUES (134);
INSERT INTO asientos (numeroasiento) VALUES (135);
INSERT INTO asientos (numeroasiento) VALUES (136);
INSERT INTO asientos (numeroasiento) VALUES (137);
INSERT INTO asientos (numeroasiento) VALUES (138);
INSERT INTO asientos (numeroasiento) VALUES (139);
INSERT INTO asientos (numeroasiento) VALUES (140);
INSERT INTO asientos (numeroasiento) VALUES (141);
INSERT INTO asientos (numeroasiento) VALUES (142);
INSERT INTO asientos (numeroasiento) VALUES (143);
INSERT INTO asientos (numeroasiento) VALUES (144);
INSERT INTO asientos (numeroasiento) VALUES (145);
INSERT INTO asientos (numeroasiento) VALUES (146);
INSERT INTO asientos (numeroasiento) VALUES (147);
INSERT INTO asientos (numeroasiento) VALUES (148);
INSERT INTO asientos (numeroasiento) VALUES (149);
INSERT INTO asientos (numeroasiento) VALUES (150);
INSERT INTO asientos (numeroasiento) VALUES (151);
INSERT INTO asientos (numeroasiento) VALUES (152);
INSERT INTO asientos (numeroasiento) VALUES (153);
INSERT INTO asientos (numeroasiento) VALUES (154);
INSERT INTO asientos (numeroasiento) VALUES (155);
INSERT INTO asientos (numeroasiento) VALUES (156);
INSERT INTO asientos (numeroasiento) VALUES (157);
INSERT INTO asientos (numeroasiento) VALUES (158);
INSERT INTO asientos (numeroasiento) VALUES (159);
INSERT INTO asientos (numeroasiento) VALUES (160);
INSERT INTO asientos (numeroasiento) VALUES (161);
INSERT INTO asientos (numeroasiento) VALUES (162);
INSERT INTO asientos (numeroasiento) VALUES (163);
INSERT INTO asientos (numeroasiento) VALUES (164);
INSERT INTO asientos (numeroasiento) VALUES (165);
INSERT INTO asientos (numeroasiento) VALUES (166);



-- // aerolineas: Las aerolíneas.

-- Inserciones en la tabla 'aerolineas'

-- Aerolíneas de España
INSERT INTO aerolineas (nombre) VALUES ('Iberia');
INSERT INTO aerolineas (nombre) VALUES ('Vueling');
INSERT INTO aerolineas (nombre) VALUES ('Air Europa');

-- Aerolíneas de Francia
INSERT INTO aerolineas (nombre) VALUES ('Air France');
INSERT INTO aerolineas (nombre) VALUES ('EasyJet');
INSERT INTO aerolineas (nombre) VALUES ('Transavia');

-- Aerolíneas de Estados Unidos
INSERT INTO aerolineas (nombre) VALUES ('American Airlines');
INSERT INTO aerolineas (nombre) VALUES ('Delta Air Lines');
INSERT INTO aerolineas (nombre) VALUES ('United Airlines');

-- Aerolíneas de Alemania
INSERT INTO aerolineas (nombre) VALUES ('Lufthansa');
INSERT INTO aerolineas (nombre) VALUES ('Eurowings');
INSERT INTO aerolineas (nombre) VALUES ('Condor');

-- Aerolíneas de Colombia
INSERT INTO aerolineas (nombre) VALUES ('Avianca');
INSERT INTO aerolineas (nombre) VALUES ('LATAM Airlines');
INSERT INTO aerolineas (nombre) VALUES ('Viva Air');


-- // puestostripulacion: Los puestos de la tripulación.

-- Inserciones en la tabla 'puestostripulacion'

INSERT INTO puestostripulacion (nombre) VALUES ('Piloto');
INSERT INTO puestostripulacion (nombre) VALUES ('Copiloto');
INSERT INTO puestostripulacion (nombre) VALUES ('Sobrecargo');
INSERT INTO puestostripulacion (nombre) VALUES ('Azafata');
INSERT INTO puestostripulacion (nombre) VALUES ('Técnico de vuelo');
INSERT INTO puestostripulacion (nombre) VALUES ('Mecánico de vuelo');





-- // empleados: Los empleados que dependen de los tipos de documentos, puestos de tripulación, aeropuertos y aerolíneas.

-- Inserciones en la tabla 'empleados'

-- Empleados de Iberia (España)
-- Ensure the empleados table exists with the correct structure


-- Insert employees into the empleados table with specified idrol values
INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (1, 'Juan Pérez', 1, '12345678', '2023-01-15', 1, 1, 'MAD1', '123', 3);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (2, 'Ana Martínez', 1, '87654321', '2023-02-20', 3, 1, 'BCN1', '123', 4);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (3, 'Pedro Gómez', 2, 'P9876543', '2023-03-10', 2, 1, 'MAD1', '123', 5);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (4, 'Elena Sánchez', 1, 'S5678901', '2023-04-05', 1, 1, 'BCN1', '123', 4);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (5, 'Carlos Ruiz', 3, 'C2345678', '2023-05-15', 3, 1, 'MAD1', '123', 5);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (6, 'Laura Fernández', 1, 'L3456789', '2023-06-20', 1, 1, 'BCN1', '123', 3);

-- Empleados de Air France (Francia)
INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (7, 'Pierre Dupont', 2, 'A9876543', '2023-07-15', 1, 4, 'PAR1', '123', 4);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (8, 'Marie Leclerc', 1, 'M8765432', '2023-08-20', 2, 4, 'PAR1', '123', 5);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (9, 'Jacques Martin', 1, 'J7654321', '2023-09-10', 3, 4, 'PAR1', '123', 3);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (10, 'Sophie Bernard', 3, 'S6543210', '2023-10-05', 1, 4, 'PAR1', '123', 4);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (11, 'Étienne Lefevre', 1, 'E5432109', '2023-11-15', 2, 4, 'PAR1', '123', 5);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (12, 'Charlotte Moreau', 1, 'C4321098', '2023-12-20', 1, 4, 'PAR1', '123', 3);

-- Empleados de American Airlines (Estados Unidos)
INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (13, 'John Smith', 1, 'J5678901', '2024-01-15', 1, 7, 'NYC1', '123', 4);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (14, 'Emily Johnson', 1, 'E4567890', '2024-02-20', 2, 7, 'NYC1', '123', 5);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (15, 'Michael Brown', 1, 'M3456789', '2024-03-10', 3, 7, 'NYC1', '123', 3);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (16, 'Sarah Davis', 1, 'S2345678', '2024-04-05', 1, 7, 'NYC1', '123', 4);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (17, 'Robert Miller', 1, 'R1234567', '2024-05-15', 2, 7, 'NYC1', '123', 5);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (18, 'Olivia Wilson', 1, 'O0123456', '2024-06-20', 1, 7, 'NYC1', '123', 3);

-- Empleados de Lufthansa (Alemania)
INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (19, 'Hans Müller', 3, 'C2345678', '2024-07-15', 3, 10, 'BER1', '123', 4);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (20, 'Greta Schmidt', 1, 'G1234567', '2024-08-20', 1, 10, 'BER1', '123', 5);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (21, 'Klaus Fischer', 2, 'K2345678', '2024-09-10', 2, 10, 'BER1', '123', 3);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (22, 'Julia Weber', 1, 'J3456789', '2024-10-05', 3, 10, 'BER1', '123', 4);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (23, 'Luca Braun', 1, 'L4567890', '2024-11-15', 1, 10, 'BER1', '123', 5);

INSERT INTO empleados (id, nombre, idtipodocumento, numerodocumento, fechaingreso, idpuesto, idaerolinea, idaeropuerto, password, idrol)
VALUES (24, 'Anna Koch', 1, 'A5678901', '2024-12-20', 2, 10, 'BER1', '123', 5);



-- // aviones: Los aviones que dependen de los estados, modelos y aerolíneas.


-- Aviones de Iberia (España)
INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (1, 'EC-JNB', 250, '2018-05-15', 1, 1, 1);  -- Airbus A320

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (2, 'EC-MVM', 300, '2017-09-20', 2, 2, 1);  -- Airbus A330

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (3, 'EC-KDH', 350, '2019-02-10', 3, 3, 1);  -- Airbus A350


-- Aviones de Air France (Francia)
INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (4, 'F-GKXA', 200, '2016-11-30', 1, 4, 4);  -- Boeing 737

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (5, 'F-HMLB', 280, '2018-03-25', 2, 5, 4);  -- Boeing 777

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (6, 'F-HRBA', 320, '2019-06-12', 3, 6, 4);  -- Boeing 787


-- Aviones de American Airlines (Estados Unidos)
INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (7, 'N123AA', 220, '2017-08-15', 1, 7, 7);  -- Airbus A220

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (8, 'N234AA', 260, '2018-01-20', 2, 1, 7);  -- Airbus A320

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (9, 'N345AA', 300, '2019-04-05', 3, 2, 7);  -- Airbus A330


-- Aviones de Lufthansa (Alemania)
INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (10, 'D-AIBC', 220, '2016-10-10', 1, 4, 10);  -- Boeing 737

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (11, 'D-AILE', 280, '2017-12-05', 2, 5, 10);  -- Boeing 777

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (12, 'D-AIVA', 320, '2019-08-20', 3, 6, 10);  -- Boeing 787


-- Aviones de Avianca (Colombia)
INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (13, 'HK-5689', 180, '2017-03-10', 1, 1, 13);  -- Airbus A320

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (14, 'HK-7890', 250, '2018-05-15', 2, 2, 13);  -- Airbus A330

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (15, 'HK-9012', 300, '2019-10-01', 3, 3, 13);  -- Airbus A350


-- Aviones de Viva Air (Colombia)
INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (16, 'HK-3456', 180, '2018-02-28', 1, 7, 15);  -- ERJ-145

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (17, 'HK-4567', 250, '2019-04-15', 2, 8, 15);  -- E-Jet E2

INSERT INTO aviones (id, matricula, capacidad, fechafabricacion, idestado, idmodelo, idaerolinea)
VALUES (18, 'HK-5678', 300, '2020-07-20', 3, 9, 15);  -- Legacy 650





-- // revisiones: Las revisiones de los aviones.

-- Revisiones para avión EC-JNB (Iberia)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-02-15', 1); -- Mantenimiento programado

INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2024-06-20', 1); -- Inspección anual

-- Revisiones para avión EC-MVM (Iberia)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-03-10', 2); -- Revisión de motor

-- Revisiones para avión EC-KDH (Iberia)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-08-05', 3); -- Mantenimiento rutinario

-- Revisiones para avión F-GKXA (Air France)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-04-10', 4); -- Revisión de seguridad

-- Revisiones para avión F-HMLB (Air France)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2024-01-15', 5); -- Inspección anual

-- Revisiones para avión F-HRBA (Air France)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-09-30', 6); -- Mantenimiento programado

-- Revisiones para avión N123AA (American Airlines)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2024-01-05', 7); -- Mantenimiento rutinario

-- Revisiones para avión N234AA (American Airlines)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-07-20', 8); -- Inspección anual

-- Revisiones para avión N345AA (American Airlines)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2024-03-15', 9); -- Revisión de seguridad

-- Revisiones para avión D-AIBC (Lufthansa)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-08-30', 10); -- Inspección semestral

-- Revisiones para avión D-AILE (Lufthansa)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2024-02-10', 11); -- Mantenimiento programado

-- Revisiones para avión D-AIVA (Lufthansa)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-11-20', 12); -- Inspección anual

-- Revisiones para avión HK-5689 (Avianca)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-05-10', 13); -- Mantenimiento rutinario

-- Revisiones para avión HK-7890 (Avianca)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-10-25', 14); -- Inspección anual

-- Revisiones para avión HK-9012 (Avianca)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2024-04-15', 15); -- Revisión de seguridad

-- Revisiones para avión HK-3456 (Viva Air)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-09-10', 16); -- Mantenimiento programado

-- Revisiones para avión HK-4567 (Viva Air)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2024-02-28', 17); -- Inspección anual

-- Revisiones para avión HK-5678 (Viva Air)
INSERT INTO revisiones (fecharevision, idavion)
VALUES ('2023-12-10', 18); -- Mantenimiento rutinario


-- // revisiondetalles: Los detalles de las revisiones, que dependen de las revisiones y empleados.

-- Detalles de revisión para el avión EC-JNB (Iberia)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    1, -- idrevision correspondiente a la revisión programada del avión EC-JNB
    'Revisión completa de motor y sistemas.', -- Descripción de la revisión
    5 -- idempleado correspondiente a Carlos Ruiz, Técnico de vuelo
);

INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    2, -- idrevision correspondiente a la inspección anual del avión EC-JNB
    'Inspección detallada de fuselaje y controles.', -- Descripción de la revisión
    6 -- idempleado correspondiente a Laura Fernández, Mecánico de vuelo
);

-- Detalles de revisión para el avión EC-MVM (Iberia)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    3, -- idrevision correspondiente a la revisión de motor del avión EC-MVM
    'Pruebas de rendimiento y ajustes de motor.', -- Descripción de la revisión
    6 -- idempleado correspondiente a Laura Fernández, Mecánico de vuelo
);

-- Detalles de revisión para el avión EC-KDH (Iberia)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    4, -- idrevision correspondiente a la revisión rutinaria del avión EC-KDH
    'Verificación de sistemas de emergencia y seguridad.', -- Descripción de la revisión
    5 -- idempleado correspondiente a Carlos Ruiz, Técnico de vuelo
);

-- Detalles de revisión para el avión F-GKXA (Air France)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    5, -- idrevision correspondiente a la revisión de seguridad del avión F-GKXA
    'Inspección exhaustiva de componentes críticos.', -- Descripción de la revisión
    10 -- idempleado correspondiente a Sophie Bernard, Técnico de vuelo
);

-- Detalles de revisión para el avión F-HMLB (Air France)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    6, -- idrevision correspondiente a la inspección anual del avión F-HMLB
    'Mantenimiento preventivo de sistemas de aviónica.', -- Descripción de la revisión
    11 -- idempleado correspondiente a Étienne Lefevre, Mecánico de vuelo
);

-- Detalles de revisión para el avión F-HRBA (Air France)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    7, -- idrevision correspondiente a la revisión programada del avión F-HRBA
    'Calibración y ajustes de instrumentos de vuelo.', -- Descripción de la revisión
    12 -- idempleado correspondiente a Charlotte Moreau, Mecánico de vuelo
);

-- Detalles de revisión para el avión N123AA (American Airlines)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    8, -- idrevision correspondiente a la revisión rutinaria del avión N123AA
    'Revisión de sistemas de comunicación y navegación.', -- Descripción de la revisión
    1 -- idempleado correspondiente a Juan Pérez, Técnico de vuelo
);

-- Detalles de revisión para el avión N234AA (American Airlines)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    9, -- idrevision correspondiente a la inspección anual del avión N234AA
    'Verificación de estructuras y componentes de seguridad.', -- Descripción de la revisión
    3 -- idempleado correspondiente a Pedro Gómez, Mecánico de vuelo
);

-- Detalles de revisión para el avión N345AA (American Airlines)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    10, -- idrevision correspondiente a la revisión de seguridad del avión N345AA
    'Pruebas de rendimiento y ajustes de sistema de combustible.', -- Descripción de la revisión
    2 -- idempleado correspondiente a Ana Martínez, Técnico de vuelo
);

-- Detalles de revisión para el avión D-AIBC (Lufthansa)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    11, -- idrevision correspondiente a la inspección semestral del avión D-AIBC
    'Mantenimiento de sistemas de frenos y tren de aterrizaje.', -- Descripción de la revisión
    7 -- idempleado correspondiente a Pierre Dupont, Técnico de vuelo
);

-- Detalles de revisión para el avión D-AILE (Lufthansa)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    12, -- idrevision correspondiente a la revisión programada del avión D-AILE
    'Revisión de aviónica avanzada y sistemas de navegación.', -- Descripción de la revisión
    8 -- idempleado correspondiente a Marie Leclerc, Mecánico de vuelo
);

-- Detalles de revisión para el avión D-AIVA (Lufthansa)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    13, -- idrevision correspondiente a la inspección anual del avión D-AIVA
    'Verificación de sistemas de presurización y climatización.', -- Descripción de la revisión
    9 -- idempleado correspondiente a Jacques Martin, Mecánico de vuelo
);

-- Detalles de revisión para el avión HK-5689 (Avianca)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    14, -- idrevision correspondiente a la revisión rutinaria del avión HK-5689
    'Revisión de sistemas hidráulicos y de control de vuelo.', -- Descripción de la revisión
    13 -- idempleado correspondiente a John Smith, Técnico de vuelo
);

-- Detalles de revisión para el avión HK-7890 (Avianca)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    15, -- idrevision correspondiente a la inspección anual del avión HK-7890
    'Mantenimiento de motores y sistemas de combustible.', -- Descripción de la revisión
    14 -- idempleado correspondiente a Emily Johnson, Mecánico de vuelo
);

-- Detalles de revisión para el avión HK-9012 (Avianca)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    16, -- idrevision correspondiente a la revisión de seguridad del avión HK-9012
    'Inspección detallada de componentes de cabina y confort.', -- Descripción de la revisión
    15 -- idempleado correspondiente a Michael Brown, Técnico de vuelo
);

-- Detalles de revisión para el avión HK-3456 (Viva Air)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    17, -- idrevision correspondiente a la revisión programada del avión HK-3456
    'Calibración de sistemas de navegación y comunicación.', -- Descripción de la revisión
    17 -- idempleado correspondiente a Robert Miller, Técnico de vuelo
);

-- Detalles de revisión para el avión HK-4567 (Viva Air)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    18, -- idrevision correspondiente a la inspección anual del avión HK-4567
    'Verificación de sistemas de control de vuelo y seguridad.', -- Descripción de la revisión
    18 -- idempleado correspondiente a Olivia Wilson, Mecánico de vuelo
);

-- Detalles de revisión para el avión HK-5678 (Viva Air)
INSERT INTO revisiondetalles (idrevision, descripcion, idempleado)
VALUES (
    19, -- idrevision correspondiente a la revisión rutinaria del avión HK-5678
    'Revisión de sistemas de aviónica y control ambiental.', -- Descripción de la revisión
    19 -- idempleado correspondiente a Hans Müller, Técnico de vuelo
);

-- Viajes en julio y agosto de 2024
INSERT INTO viajes (fechaviaje, precioviaje, idorigenaeropuerto, iddestionaeropuerto)
VALUES 
    ('2024-07-01', 260.00, 'NYC1', 'PAR1'),
    ('2024-07-01', 310.00, 'BCN1', 'LAX1'),
    ('2024-07-01', 280.00, 'MAD1', 'MIA1'),
    ('2024-07-02', 320.00, 'LYO1', 'NYC1'),
    ('2024-07-02', 290.00, 'SEV1', 'PAR1'),
    ('2024-07-03', 275.00, 'MAD1', 'LAX1'),
    ('2024-07-03', 305.00, 'NYC1', 'MIA1'),
    ('2024-07-04', 340.00, 'BCN1', 'PAR1'),
    ('2024-07-04', 310.00, 'LYO1', 'MIA1'),
    ('2024-07-05', 295.00, 'SEV1', 'NYC1'),
    ('2024-07-05', 315.00, 'MAD1', 'PAR1'),
    ('2024-07-06', 325.00, 'NYC1', 'LAX1'),
    ('2024-07-06', 280.00, 'BCN1', 'MIA1'),
    ('2024-07-07', 300.00, 'LYO1', 'LAX1'),
    ('2024-07-07', 290.00, 'SEV1', 'MIA1'),
    ('2024-07-08', 310.00, 'MAD1', 'NYC1'),
    ('2024-07-08', 270.00, 'NYC1', 'PAR1'),
    ('2024-07-09', 325.00, 'BCN1', 'LAX1'),
    ('2024-07-09', 310.00, 'LYO1', 'NYC1'),
    ('2024-07-10', 285.00, 'SEV1', 'LAX1'),
    ('2024-07-10', 320.00, 'MAD1', 'MIA1'),
    ('2024-07-11', 275.00, 'NYC1', 'MIA1'),
    ('2024-07-11', 315.00, 'BCN1', 'PAR1'),
    ('2024-07-12', 305.00, 'LYO1', 'LAX1'),
    ('2024-07-12', 290.00, 'SEV1', 'NYC1'),
    ('2024-07-13', 325.00, 'MAD1', 'PAR1'),
    ('2024-07-13', 270.00, 'NYC1', 'LAX1'),
    ('2024-07-14', 310.00, 'BCN1', 'MIA1'),
    ('2024-07-14', 295.00, 'LYO1', 'PAR1'),
    ('2024-07-15', 280.00, 'SEV1', 'LAX1'),
    ('2024-07-15', 320.00, 'MAD1', 'NYC1'),
    ('2024-07-16', 275.00, 'NYC1', 'PAR1'),
    ('2024-07-16', 325.00, 'BCN1', 'LAX1'),
    ('2024-07-17', 300.00, 'LYO1', 'MIA1'),
    ('2024-07-17', 290.00, 'SEV1', 'NYC1'),
    ('2024-07-18', 310.00, 'MAD1', 'PAR1'),
    ('2024-07-18', 325.00, 'NYC1', 'LAX1'),
    ('2024-07-19', 280.00, 'BCN1', 'MIA1'),
    ('2024-07-19', 300.00, 'LYO1', 'LAX1'),
    ('2024-07-20', 290.00, 'SEV1', 'MIA1'),
    ('2024-07-20', 310.00, 'MAD1', 'NYC1'),
    ('2024-07-21', 275.00, 'NYC1', 'PAR1'),
    ('2024-07-21', 325.00, 'BCN1', 'LAX1'),
    ('2024-07-22', 310.00, 'LYO1', 'MIA1'),
    ('2024-07-22', 285.00, 'SEV1', 'LAX1'),
    ('2024-07-23', 320.00, 'MAD1', 'PAR1'),
    ('2024-07-23', 275.00, 'NYC1', 'MIA1'),
    ('2024-07-24', 305.00, 'BCN1', 'LAX1'),
    ('2024-07-24', 290.00, 'LYO1', 'NYC1'),
    ('2024-07-25', 325.00, 'SEV1', 'MIA1'),
    ('2024-07-25', 270.00, 'MAD1', 'LAX1'),
    ('2024-07-26', 310.00, 'NYC1', 'PAR1'),
    ('2024-07-26', 295.00, 'BCN1', 'MIA1'),
    ('2024-07-27', 320.00, 'LYO1', 'LAX1'),
    ('2024-07-27', 285.00, 'SEV1', 'NYC1'),
    ('2024-07-28', 275.00, 'MAD1', 'MIA1'),
    ('2024-07-28', 325.00, 'NYC1', 'LAX1'),
    ('2024-07-29', 300.00, 'BCN1', 'PAR1'),
    ('2024-07-29', 290.00, 'LYO1', 'MIA1'),
    ('2024-07-30', 310.00, 'SEV1', 'LAX1'),
    ('2024-07-30', 280.00, 'MAD1', 'NYC1'),
    ('2024-07-31', 325.00, 'NYC1', 'PAR1'),
    ('2024-08-01', 310.00, 'BCN1', 'LAX1'),
    ('2024-08-01', 295.00, 'LYO1', 'MIA1'),
    ('2024-08-02', 280.00, 'SEV1', 'NYC1'),
    ('2024-08-02', 320.00, 'MAD1', 'PAR1'),
    ('2024-08-03', 325.00, 'NYC1', 'LAX1'),
    ('2024-08-03', 275.00, 'BCN1', 'MIA1'),
    ('2024-08-04', 290.00, 'LYO1', 'PAR1'),
    ('2024-08-04', 310.00, 'SEV1', 'NYC1'),
    ('2024-08-05', 275.00, 'MAD1', 'LAX1'),
    ('2024-08-05', 325.00, 'NYC1', 'MIA1'),
    ('2024-08-06', 280.00, 'BCN1', 'PAR1'),
    ('2024-08-06', 295.00, 'LYO1', 'LAX1'),
    ('2024-08-07', 310.00, 'SEV1', 'NYC1'),
    ('2024-08-07', 320.00, 'MAD1', 'MIA1'),
    ('2024-08-08', 325.00, 'NYC1', 'PAR1'),
    ('2024-08-08', 275.00, 'BCN1', 'LAX1')
;


-- Conexiones para los viajes
INSERT INTO conexionesvuelos  (numeroconexion, idviaje, idavion, salidaidaeropuerto, llegadaidaeropuerto)
VALUES
    ('CON1', 1, 1, 'NYC1', 'LAX1'),
    ('CON2', 1, 2, 'LAX1', 'PAR1'),
    ('CON3', 2, 3, 'BCN1', 'NYC1'),
    ('CON4', 2, 4, 'NYC1', 'MIA1'),
    ('CON5', 3, 5, 'MAD1', 'LAX1'),
    ('CON6', 3, 6, 'LAX1', 'MIA1'),
    ('CON7', 4, 7, 'LYO1', 'NYC1'),
    ('CON8', 4, 8, 'NYC1', 'PAR1'),
    ('CON9', 5, 9, 'SEV1', 'PAR1'),
    ('CON10', 5, 10, 'PAR1', 'NYC1'),
    ('CON11', 6, 11, 'MAD1', 'MIA1'),
    ('CON12', 6, 12, 'MIA1', 'LAX1'),
    ('CON13', 7, 13, 'NYC1', 'LAX1'),
    ('CON14', 7, 14, 'LAX1', 'PAR1'),
    ('CON15', 8, 15, 'BCN1', 'MIA1'),
    ('CON16', 8, 16, 'MIA1', 'NYC1'),
    ('CON17', 9, 17, 'LYO1', 'LAX1'),
    ('CON18', 9, 18, 'LAX1', 'PAR1'),
    ('CON19', 10, 1, 'SEV1', 'NYC1'),
    ('CON20', 10, 10, 'NYC1', 'MIA1'),
    ('CON21', 11, 1, 'MAD1', 'PAR1'),
    ('CON22', 11, 2, 'PAR1', 'NYC1'),
    ('CON23', 12, 3, 'NYC1', 'LAX1'),
    ('CON24', 12, 4, 'LAX1', 'MIA1'),
    ('CON25', 13, 5, 'BCN1', 'PAR1'),
    ('CON26', 13, 6, 'PAR1', 'LAX1'),
    ('CON27', 14, 7, 'LYO1', 'MIA1'),
    ('CON28', 14, 8, 'MIA1', 'NYC1'),
    ('CON29', 15, 9, 'SEV1', 'LAX1'),
    ('CON30', 15, 10, 'LAX1', 'PAR1'),
    ('CON31', 16, 11, 'MAD1', 'NYC1'),
    ('CON32', 16, 12, 'NYC1', 'MIA1'),
    ('CON33', 17, 13, 'NYC1', 'LAX1'),
    ('CON34', 17, 14, 'LAX1', 'PAR1'),
    ('CON35', 18, 15, 'BCN1', 'MIA1')
;




-- // tripulantes: Los tripulantes de las conexiones de vuelos.

-- Inserción de tripulantes

-- Tripulante 1: Juan Pérez en la conexión CV-001 (Vuelo 1)
INSERT INTO tripulantes (idconexion, idempleado)
VALUES (
    1, -- idconexion correspondiente a la conexión CV-001
    1  -- idempleado correspondiente a Juan Pérez
);

-- Tripulante 2: Ana Martínez en la conexión CV-001 (Vuelo 1)
INSERT INTO tripulantes (idconexion, idempleado)
VALUES (
    1, -- idconexion correspondiente a la conexión CV-001
    2  -- idempleado correspondiente a Ana Martínez
);

-- Tripulante 3: Pedro Gómez en la conexión CV-002 (Vuelo 2)
INSERT INTO tripulantes (idconexion, idempleado)
VALUES (
    2, -- idconexion correspondiente a la conexión CV-002
    3  -- idempleado correspondiente a Pedro Gómez
);

-- Tripulante 4: Elena Sánchez en la conexión CV-003 (Vuelo 3)
INSERT INTO tripulantes (idconexion, idempleado)
VALUES (
    3, -- idconexion correspondiente a la conexión CV-003
    4  -- idempleado correspondiente a Elena Sánchez
);

-- Tripulante 5: Carlos Ruiz en la conexión CV-004 (Vuelo 4)
INSERT INTO tripulantes (idconexion, idempleado)
VALUES (
    4, -- idconexion correspondiente a la conexión CV-004
    5  -- idempleado correspondiente a Carlos Ruiz
);



-- // asientodetallereservaviajeconexion: La relación entre los asientos, detalles de reserva y conexiones de vuelos.

-- Inserción en la tabla asientodetallereservaviajeconexion

-- Relación 1: Conexión CV-001 (Vuelo 1), Detalle de Reserva 1, Asiento 1
INSERT INTO asientodetallereservaviajeconexion (idconexionvuelos, iddetallereserva, idasientos)
VALUES (1, 1, 1);

-- Relación 2: Conexión CV-002 (Vuelo 2), Detalle de Reserva 2, Asiento 2
INSERT INTO asientodetallereservaviajeconexion (idconexionvuelos, iddetallereserva, idasientos)
VALUES (2, 2, 2);

-- Relación 3: Conexión CV-003 (Vuelo 3), Detalle de Reserva 3, Asiento 3
INSERT INTO asientodetallereservaviajeconexion (idconexionvuelos, iddetallereserva, idasientos)
VALUES (3, 3, 3);

-- Relación 4: Conexión CV-004 (Vuelo 4), Detalle de Reserva 4, Asiento 4
INSERT INTO asientodetallereservaviajeconexion (idconexionvuelos, iddetallereserva, idasientos)
VALUES (4, 4, 4);

-- Relación 5: Conexión CV-005 (Vuelo 5), Detalle de Reserva 5, Asiento 5
INSERT INTO asientodetallereservaviajeconexion (idconexionvuelos, iddetallereserva, idasientos)
VALUES (5, 5, 5);

