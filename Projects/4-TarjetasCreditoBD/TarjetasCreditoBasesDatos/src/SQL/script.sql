DROP DATABASE IF EXISTS tarjetaCredito; -- Elimina la base de datos si existe
CREATE DATABASE tarjetaCredito; -- Crea la base de datos
\c tarjetaCredito; -- Conecta con la base de datos

-- Crea la tablas
CREATE TABLE tarjetaCredito (
    titular VARCHAR(80) NOT NULL,
    nif VARCHAR(9) NOT NULL,
    pin VARCHAR(4) NOT NULL,
    limite INTEGER NOT NULL,
    mes_caducidad INTEGER NOT NULL,
    anio_caducidad INTEGER NOT NULL,
    numero_tarjeta VARCHAR(16) NOT NULL,
    cvv VARCHAR(3) NOT NULL,
    PRIMARY KEY (numero_tarjeta)
);

CREATE TABLE movimientos (
    id SERIAL PRIMARY KEY,
    id_numero_tarjeta VARCHAR(16) NOT NULL,
    cantidad DECIMAL(10,2) NOT NULL,
    concepto VARCHAR(50) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    FOREIGN KEY (id_numero_tarjeta) REFERENCES tarjetaCredito(numero_tarjeta) ON DELETE CASCADE
);

-- Inserta datos en la tabla tarjetaCredito
INSERT INTO tarjetaCredito VALUES ('Cesareo Dueñas Sastre', '57564187V', '5443', 1200, 12, 2028, '4435932217836064', '543');
INSERT INTO tarjetaCredito VALUES ('Mauricio Zamorano Santos', 'D50713577', '5111', 2000, 12, 2028, '4789895682585502', '555');
INSERT INTO tarjetaCredito VALUES ('Pere Cuadrado Martin', 'X9336826E', '8542', 5000, 11, 2030, '4789073216165569', '652');
INSERT INTO tarjetaCredito VALUES ('Miguel Angel Crespo', '13703835K', '1111', 3400, 1, 2030, '4731462044502128', '984');
INSERT INTO tarjetaCredito VALUES ('Javier Garcia Cuesta', '27185233S', '9843', 1560, 11, 2028, '4545490782281338', '624');

-- Inserta datos en la tabla movimientos
INSERT INTO movimientos VALUES (DEFAULT, '4435932217836064', 100, 'Compra en Amazon', '2023-05-01 12:00:00');
INSERT INTO movimientos VALUES (DEFAULT, '4435932217836064', 200, 'Compra en MediaMarkt', '2023-05-02 12:00:00');
INSERT INTO movimientos VALUES (DEFAULT, '4435932217836064', 300, 'Compra en Carrefour', '2023-05-03 12:00:00');

INSERT INTO movimientos VALUES (DEFAULT, '4789895682585502', 100, 'Compra en Amazon', '2023-05-01 12:00:00');
INSERT INTO movimientos VALUES (DEFAULT, '4789895682585502', 50, 'Luz', '2023-05-02 12:00:00');

INSERT INTO movimientos VALUES (DEFAULT, '4789073216165569', 100, 'Luz', '2023-05-01 12:00:00');
INSERT INTO movimientos VALUES (DEFAULT, '4789073216165569', 200, 'Compra en MediaMarkt', '2023-05-02 12:00:00');

INSERT INTO movimientos VALUES (DEFAULT, '4731462044502128', 80, 'Compra en Amazon', '2023-05-01 12:00:00');
INSERT INTO movimientos VALUES (DEFAULT, '4731462044502128', 200, 'Compra en MediaMarkt', '2023-05-02 12:00:00');

INSERT INTO movimientos VALUES (DEFAULT, '4545490782281338', 500, 'Compra en Mercadona', '2023-05-01 12:00:00');
INSERT INTO movimientos VALUES (DEFAULT, '4545490782281338', 60, 'Compra Pescado', '2023-05-02 12:00:00');