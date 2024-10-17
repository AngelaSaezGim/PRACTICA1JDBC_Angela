CREATE SCHEMA IF NOT EXISTS practica1;
USE practica1;

-- TABLAS PRINCIPALES (Clientes, articulos, pedidos y fabricas)

CREATE TABLE Cliente (
  idCliente INT PRIMARY KEY AUTO_INCREMENT,
  saldo DECIMAL(10,2),
  limiteCredito DOUBLE CHECK (limiteCredito <= 18000), -- RESTRICCIÓN LIMITE CREDITO - en ningún caso debe superar los 18.000 €
  descuento DECIMAL(10,2)
);

CREATE TABLE Articulo (
  idArticulo INT PRIMARY KEY AUTO_INCREMENT,
  descripcion VARCHAR(255)
);

-- Tablas auxiliares: Direcciones
-- Direcciones de envío (varias por cliente)
-- Nota: Se entenderá una dirección como Nº, Calle, Comuna y Ciudad. 
CREATE TABLE DireccionEnvio (
  idDireccion INT PRIMARY KEY AUTO_INCREMENT,
  numero INT,
  calle VARCHAR(100) NOT NULL,
  comuna VARCHAR(100) NOT NULL,
  ciudad VARCHAR(100) NOT NULL,
  idCliente INT, 
	CONSTRAINT fk_Direccion_Cliente FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente) ON DELETE CASCADE  -- -- Nombrar la clave foránea Relación con la tabla Cliente
);

-- Para cada pedido:
-- Cada pedido tiene un encabezado y un cuerpo. El encabezado está formado por el número de 
-- cliente (id), dirección de envío (idDireccion) y fecha del pedido.
CREATE TABLE Pedido (
  idPedido INT PRIMARY KEY AUTO_INCREMENT,
  fecha DATETIME, 
  numeroComanda INT,  
  idCliente INT, 
  idDireccion INT, 
  CONSTRAINT fk_Pedido_Cliente FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente) ON DELETE CASCADE ,
  CONSTRAINT fk_Pedido_Direccion FOREIGN KEY (idDireccion) REFERENCES DireccionEnvio(idDireccion) ON DELETE CASCADE 
);

-- Tablas auxiliares: LineasPedido para las líneas de un pedido.
-- El cuerpo del pedido son varias líneas, y en cada línea se especifican el número del artículo -- solicitado y la cantidad.
CREATE TABLE LineaPedido (
  idLineaPedido INT PRIMARY KEY AUTO_INCREMENT,
  idPedido INT,
  idArticulo INT,
  cantidad INT,
  CONSTRAINT fk_LineaPedido_Pedido FOREIGN KEY (idPedido) REFERENCES Pedido(idPedido) ON DELETE CASCADE ,
  CONSTRAINT fk_LineaPedido_Articulo FOREIGN KEY (idArticulo) REFERENCES Articulo(idArticulo) ON DELETE CASCADE 
);

-- Además, se ha determinado que se debe almacenar la información de las fábricas. No obstante, -- dado el uso de distribuidores, se usará:
-- Número de la fábrica (único)
-- Teléfono de contacto
CREATE TABLE Fabrica (
  idFabrica INT PRIMARY KEY AUTO_INCREMENT,
  telefonoContacto VARCHAR(20),
  totalArticulos INT
);

-- Tabla de relación: ArticulosFabricas para relacionar artículos con fábricas y almacenar existencias.
-- Para cada artículo:
-- Fábricas que lo distribuyen
-- Existencias de ese artículo en cada fábrica (nº articulos provistos)
--  A més, es desitgen veure quants articles (en total) proveeix la fàbrica. 
-- També, per informació estratègica, es podria incloure informació de fàbriques alternatives respecte de les quals ja fabriquen articles per a aquesta empresa. 

CREATE TABLE ArticuloFabrica (
  idArticulo INT,
  idFabrica INT,
  existencias INT,
	precio DECIMAL(10, 2),
  PRIMARY KEY (idArticulo, idFabrica), -- Clave primaria compuesta (tipo artículo que existe en una fábrica)
	CONSTRAINT fk_ArticuloFabrica_Articulo FOREIGN KEY (idArticulo) REFERENCES Articulo(idArticulo) ON DELETE CASCADE ,
	CONSTRAINT fk_ArticuloFabrica_Fabrica FOREIGN KEY (idFabrica) REFERENCES Fabrica(idFabrica) ON DELETE CASCADE 
);

-- TABLA FABRICAS ALTERNATIVAS - posibilidad de regitrar fabricas alternativas
-- También, por información estratégica, se podría incluir información de fábricas alternativas respecto a las que ya fabrican artículos para esta empresa.

CREATE TABLE FabricaAlternativa (
  idFabricaPrincipal INT,             
  idFabricaAlternativa INT,            -- Fábrica alternativa (posible proveedor alternativo)
  PRIMARY KEY (idFabricaPrincipal, idFabricaAlternativa),  -- Clave primaria compuesta (principal y alternativa)
  -- Fabrica alternativa y principal = Ambas deben estar presentes en la tabla Fabrica
  -- Cada valor en idFabricaPrincipal debe existir en la columna idFabrica de la tabla Fabrica
  CONSTRAINT fk_FabricaAlternativa_idFabricaPrincipalFabrica FOREIGN KEY (idFabricaPrincipal) REFERENCES Fabrica(idFabrica) ON DELETE CASCADE ,   
  -- Cada valor en idFabricaAlternativa debe existir en la columna idFabrica de la tabla Fabrica.
  CONSTRAINT fk_FabricaAlternativa_idFabricaAlternativaFabrica FOREIGN KEY (idFabricaAlternativa) REFERENCES Fabrica(idFabrica) ON DELETE CASCADE   
);

-- Además, se desea ver cuántos artículos (en total) provee la fábrica.--
-- Vista: ArticulosPorFabrica calcula el número total de artículos por fábrica.
-- El atributo "Nº artículos provistos"
/*
Para cada fábrica (idFabrica), suma las cantidades de los diferentes artículos que tiene disponibles (columna existencias en la tabla ArticulosFabricas).
*/-- Además, se desea ver cuántos artículos (en total) provee la fábrica.--
-- Vista: ArticulosPorFabrica calcula el número total de artículos por fábrica.
-- El atributo "Nº artículos provistos"
-- Vista = obtener una lista de fábricas junto con el número total de artículos que provee cada una
-- ALMACENO LA CONSULTA EN UNA VISTA

CREATE OR REPLACE VIEW ArticuloPorFabrica AS
SELECT af.idFabrica, SUM(af.existencias) AS totalArticulos
FROM ArticuloFabrica af
GROUP BY af.idFabrica;

DESCRIBE ArticuloFabrica;
DESCRIBE ArticuloPorFabrica;

SELECT idFabrica, SUM(existencias) AS totalArticulos
FROM ArticuloFabrica
GROUP BY idFabrica;

/*INSERTANDO DATOS PRUEBA*/
GRANT ALL PRIVILEGES ON `practica1`.* TO 'root'@'localhost';

INSERT INTO Cliente(saldo,limiteCredito,descuento)VALUES(15,15000,4);
SELECT * FROM Cliente;

INSERT INTO Articulo(descripcion)VALUES("lapiz");
INSERT INTO Articulo (descripcion) VALUES ('Peras');
INSERT INTO Articulo (descripcion) VALUES ('Manzanas');
SELECT * FROM Articulo;

INSERT INTO DireccionEnvio(numero,calle,comuna,ciudad,idCliente)VALUES(2,'calle 2','comuna1','Madrid',1);
SELECT * FROM DireccionEnvio;

INSERT INTO Pedido (fecha, numeroComanda, idCliente, idDireccion) 
VALUES (NOW(), 1001, 1, 1);
INSERT INTO Pedido (fecha, numeroComanda, idCliente, idDireccion) 
VALUES ('2013-03-02 14:00:00', 1000, 1, 1);
SELECT * FROM Pedido;

INSERT INTO LineaPedido (idPedido, idArticulo, cantidad) 
VALUES (1, 1, 50);
SELECT * FROM LineaPedido;

INSERT INTO Fabrica(telefonoContacto,totalArticulos) VALUES('66666666',0);
INSERT INTO Fabrica (telefonoContacto,totalArticulos) VALUES ('77777777',0); -- Hago 2 para fabricaAlternativa
INSERT INTO Fabrica (telefonoContacto,totalArticulos) VALUES ('123456789',0);
INSERT INTO Fabrica (telefonoContacto,totalArticulos) VALUES ('987654321',0);
SELECT * FROM fabrica;

INSERT INTO ArticuloFabrica (idArticulo, idFabrica, existencias, precio) VALUES (2, 2, 100, 15.50);
INSERT INTO ArticuloFabrica (idArticulo, idFabrica, existencias, precio) VALUES (1, 2, 80, 2.30);
INSERT INTO ArticuloFabrica (idArticulo, idFabrica, existencias, precio) VALUES (3, 3, 50, 20);
SELECT * FROM ArticuloFabrica;

INSERT INTO FabricaAlternativa (idFabricaPrincipal, idFabricaAlternativa) VALUES (2, 5); -- La fábrica 2 tiene como alternativa la fábrica 5
-- EN codigo = no podria coincidir - ej 1,1
SELECT * FROM FabricaAlternativa;
SELECT * FROM Fabrica

/*
DROP TABLE IF EXISTS FabricaAlternativa;
DROP TABLE IF EXISTS ArticuloFabrica;
DROP TABLE IF EXISTS LineaPedido;
DROP TABLE IF EXISTS Pedido;
DROP TABLE IF EXISTS DireccionEnvio;
DROP TABLE IF EXISTS Articulo;
DROP TABLE IF EXISTS Fabrica;
DROP TABLE IF EXISTS Cliente;*/
