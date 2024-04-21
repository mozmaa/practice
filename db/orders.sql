DROP SCHEMA IF EXISTS onlineOrders;
CREATE SCHEMA onlineOrders DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE onlineOrders;

CREATE TABLE product(
id BIGINT AUTO_INCREMENT,
referenceCode VARCHAR (4) UNIQUE NOT NULL,
productName VARCHAR (50) NOT NULL,
price DECIMAL (12,2) NOT NULL,
freeDeliv BOOL DEFAULT false,
PRIMARY KEY (id)
);

CREATE TABLE orders (
id BIGINT AUTO_INCREMENT,
orderData TIMESTAMP NOT NULL,
street VARCHAR (50),
streetNum INT,
idProduct BIGINT,
PRIMARY KEY (id),
FOREIGN KEY (idProduct) REFERENCES products (id)
);

# proizvodi: sifra, naziv, cena, besplatna dostava
INSERT INTO products (id, referenceCode, productName, price, freeDeliv) VALUES (1, '0001', 'Proizvod 1' 5000.00, false);
INSERT INTO products (id, referenceCode, productName, price, freeDeliv) VALUES (2, '0002', 'Proizvod 2' 100000.00, false);
INSERT INTO products (id, referenceCode, productName, price, freeDeliv) VALUES (3, '0003', 'Proizvod 3', 15000.00, true);

# porudžbine: datum i vreme, ulica, broj, proizvod
'2021-09-01 10:00', 'Bul. Oslobođenja', 10, PRVI
'2021-09-01 14:00', 'Bul. Mihajla Pupina', 10, PRVI
'2021-09-01 20:00', 'Bul. Oslobođenja', 20, DRUGI
'2021-09-02 10:30', 'Bul. Cara Lazara', 10, PRVI
'2021-09-02 14:30', 'Bul. Oslobođenja', 30, TRECI
'2021-09-03 10:00', 'Bul. Mihajla Pupina', 20, DRUGI
'2021-09-03 14:00', 'Bul. Mihajla Pupina', 30, TRECI
'2021-09-03 20:00', 'Bul. Cara Lazara', 20, PRVI