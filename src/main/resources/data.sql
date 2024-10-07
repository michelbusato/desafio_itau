CREATE TABLE Category (
    ID int AUTO_INCREMENT,
    name varchar(255),
    description varchar(255),
    iof NUMERIC(6, 2),
    pis NUMERIC(6, 2),
    confins NUMERIC(6, 2),
    PRIMARY KEY (ID)
);

INSERT INTO Category (name, description, iof, pis, confins) VALUES ('VIDA', 'Seguro de Vida Individual', 1.0, 2.2, null);
INSERT INTO Category (name, description, iof, pis, confins) VALUES ('AUTO', 'Seguro de Auto Individual', 5.5, 4.0, 1.0);
INSERT INTO Category (name, description, iof, pis, confins) VALUES ('VIAGEM', 'Seguro Viagem Individual', 2.0, 4.0, 1.0);
INSERT INTO Category (name, description, iof, pis, confins) VALUES ('RESIDENCIAL', 'Seguro Residencial Individual', 4.0, null, 3.0);
INSERT INTO Category (name, description, iof, pis, confins) VALUES ('PATRIMONIAL', 'Seguro Patrimonial Individual', 5.0, 3.0, null);

CREATE TABLE Quotation (
    ID int AUTO_INCREMENT,
    uuid varchar(36),
    name varchar(255),
    value_base NUMERIC(10, 2),
    value_tarifed NUMERIC(10, 2),
	CATEGORY_ID INT,
    PRIMARY KEY (ID),
    foreign key (CATEGORY_ID) references Category(ID)
);