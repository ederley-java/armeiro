CREATE DATABASE armeirobd4;

USE armeirobd4;

create table guardas (
id int (15) not null auto_increment,
matricula varchar (15),
nome varchar (50),
endereco varchar (50),
telefone varchar (50),
email varchar (50),
sexo varchar (15),
situacao varchar (50),
status varchar (15)            
primary key (id));

create table livroparte (
id int (10) not null auto_increment,
nomeArmeiro varchar (15),
dia_entrada varchar (10),
hora_entrada varchar (10),
historico varchar (1000),
dia_saida varchar (10),
hora_saida varchar (10),
primary key (id));

create table produto (
id int (15) not null auto_increment,	
cod varchar (10),
marca varchar (15),
tipo varchar (20),
numeroSerie varchar (20),
descricao varchar (50),
observacao varchar (80),
localizacao varchar (50),
historico varchar (1000),
primary key (id));

create table cargaDiaria (
id int (15) not null auto_increment,
dia varchar (10) not null,
codArmeiro int (15),
codGuarda int (15),
codProduto int (15),
observacao varchar (100),
dia1 varchar (15), 
hora1 varchar (10),
devolvido varchar (10),
dia2 varchar (15), 
hora2 varchar (10),
primary key (id),
CONSTRAINT FK_nomeArmeiro_nome FOREIGN KEY (codArmeiro) REFERENCES guardas (id),
CONSTRAINT FK_nomeGuarda_nome FOREIGN KEY (codGuarda) REFERENCES guardas (id),
CONSTRAINT FK_codProduto_produto FOREIGN KEY (codProduto) REFERENCES produto (id));