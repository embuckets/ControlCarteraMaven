CREATE TABLE asegurados(
    aseguradoId INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre varchar(50) NOT NULL,
    apPaterno varchar(50),
    apMaterno varchar(50),
    rfc varchar(13),
    nacimiento DATE,
    PRIMARY KEY (aseguradoId),
    CONSTRAINT UNQ_asegurado UNIQUE (nombre, apPaterno, apMaterno)
);

CREATE TABLE telefonos(
    telefonoId INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    aseguradoId INT NOT NULL REFERENCES asegurados(aseguradoId),
    telefono varchar(20) NOT NULL,
    PRIMARY KEY (telefonoId),
    CONSTRAINT UNQ_telefono UNIQUE (aseguradoId, telefono)
);

CREATE TABLE emails(
    emailId INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    aseguradoId INT NOT NULL REFERENCES asegurados(aseguradoId),
    email varchar(40) NOT NULL,
    PRIMARY KEY (emailId),
    CONSTRAINT UNQ_email UNIQUE (aseguradoId, email)
);

CREATE TABLE estados(
    estado varchar(50) NOT NULL,
    PRIMARY KEY (estado)
);

CREATE TABLE domicilios(
    domicilioId INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    aseguradoId INT NOT NULL REFERENCES asegurados(aseguradoId),
    calle varchar(50),
    exterior varchar(50),
    interior varchar(20),
    codPostal char(5),
    colonia varchar(50),
    delegacion varchar(50),
    estado varchar(50) REFERENCES estados(estado),
    PRIMARY KEY (domicilioId),
    CONSTRAINT UNQ_domicilio UNIQUE (aseguradoId)
);

CREATE TABLE aseguradoras(
    aseguradora varchar(20) NOT NULL,
    PRIMARY KEY (aseguradora)
);

CREATE TABLE ramos(
    ramo varchar(30) NOT NULL,
    PRIMARY KEY (ramo)
);

CREATE TABLE polizas(
    polizaId INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    numero varchar(20) NOT NULL,
    aseguradora varchar(20) NOT NULL REFERENCES aseguradoras(aseguradora),
    asegurado INT NOT NULL REFERENCES asegurados(aseguradoId),
    ramo varchar(30) NOT NULL REFERENCES ramos(ramo),
    producto varchar(50),
    plan varchar(50),
    inicioVigencia DATE NOT NULL,
    finVigencia DATE NOT NULL,
    conductoCobro varchar(15) NOT NULL, CHECK (conductoCobro IN ('agente', 'cash', 'cat')),
    formaPago varchar(20) NOT NULL, CHECK (formaPago IN ('mensual','trimestral','semestral','anual')),
    prima DECIMAL(9,2) NOT NULL,
    moneda varchar(10) NOT NULL,
    deducible DECIMAL(9,2),
    monedaDeducible varchar(10),
    sumaAsegurada DECIMAL(9,2),
    monedaSumaAsegurada varchar(10),
    coaseguro SMALLINT,
    comentarios varchar(70),
    PRIMARY KEY (polizaId),
    CONSTRAINT UNQ_poliza UNIQUE (numero, inicioVigencia),
    CONSTRAINT CHK_moneda CHECK (moneda IN ('pesos','dolares','umam') AND 
    monedaDeducible IN ('pesos','dolares','umam') AND 
    monedaSumaAsegurada IN ('pesos','dolares','umam'))
);

CREATE TABLE recibos(
    recibosId INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    polizaId INT NOT NULL REFERENCES polizas(polizaId),
    cubreDesde DATE NOT NULL,
    cubreHasta DATE NOT NULL,
    importe DECIMAL(9,2) NOT NULL,
    cobranza varchar(9) NOT NULL, CHECK (cobranza IN ('pendiente','pagado')),
    PRIMARY KEY (recibosId),
    CONSTRAINT UNQ_recibo UNIQUE (polizaId, cubreDesde)
);

CREATE TABLE beneficiarios(
    beneficiariosId INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    polizaId INT NOT NULL REFERENCES polizas(polizaId),
    nombre varchar(50) NOT NULL,
    apPaterno varchar(50) NOT NULL,
    apMaterno varchar(50) NOT NULL,
    nacimiento DATE NOT NULL,
    PRIMARY KEY (beneficiariosId),
    CONSTRAINT UNQ_beneficiario UNIQUE (polizaId, nombre, apPaterno, apMaterno)
);

CREATE INDEX idx_cobranza ON recibos(cobranza);
CREATE INDEX idx_cubreDede ON recibos(cubreDesde);