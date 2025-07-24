CREATE TABLE customer
(
    customerNumber INTEGER PRIMARY KEY,
    name           VARCHAR(50),
    email          VARCHAR(50),
    phone          VARCHAR(50)
);

CREATE TABLE creditcard
(
    cardNumber     VARCHAR(50) PRIMARY KEY,
    type           VARCHAR(50),
    validationDate VARCHAR(50),
    customernumber INTEGER
);

CREATE TABLE product
(
    product_number VARCHAR(50) PRIMARY KEY,
    name           VARCHAR(50),
    price          INTEGER(50),
    supplier       VARCHAR(50)
);

CREATE TABLE supplier
(
    name  VARCHAR(50) PRIMARY KEY,
    phone VARCHAR(50)
);
