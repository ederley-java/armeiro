USE armeirobd4;
DROP DATABASE armeirobd4;

CREATE DATABASE armeirobd4;
USE armeirobd4;

create table guarda (
    id        INT (15) NOT NULL auto_increment,
    matricula VARCHAR (15),
    nome      VARCHAR (50),
    endereco  VARCHAR (50),
    telefone  VARCHAR (50),
    email     VARCHAR (50),
    sexo      VARCHAR (15),
    situacao  VARCHAR (50),
    status    VARCHAR (15),

    PRIMARY KEY (id)
);

create table livroparte (
    id           INT (10) NOT NULL auto_increment,
    nome_armeiro VARCHAR (15),
    dia_entrada  VARCHAR (10),
    hora_entrada VARCHAR (10),
    historico    VARCHAR (1000),
    dia_saida    VARCHAR (10),
    hora_saida   VARCHAR (10),

    PRIMARY KEY (id)
);

create table produto (
    id INT (15) NOT NULL auto_increment,	
    cod VARCHAR (10),
    marca VARCHAR (15),
    tipo VARCHAR (20),
    numero_serie VARCHAR (20),
    descricao VARCHAR (50),
    observacao VARCHAR (80),
    localizacao VARCHAR (50),
    historico VARCHAR (1000),

    PRIMARY KEY (id)
);

create table carga_diaria (
    id INT (15) NOT NULL auto_increment,
    id_armeiro INT (15),
    id_guarda INT (15),
    id_produto INT (15),
    observacao VARCHAR (100),
    cautelado BOOLEAN,
    dia VARCHAR (10) NOT NULL,
    dia1 VARCHAR (15),
    hora1 VARCHAR (10),
    dia2 VARCHAR (15), 
    hora2 VARCHAR (10),
    PRIMARY KEY (id),

    CONSTRAINT FK_carga_diaria_armeiro FOREIGN KEY (id_armeiro) REFERENCES guarda (id),
    CONSTRAINT FK_carga_diaria_guarda  FOREIGN KEY (id_guarda)  REFERENCES guarda (id),
    CONSTRAINT FK_carga_diaria_produto FOREIGN KEY (id_produto) REFERENCES produto (id)
);