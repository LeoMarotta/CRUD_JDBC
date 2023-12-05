--------------------------------- Postgresql schema ----------------------------------------------
create sequence seqdepartamento;

create table departamento (
cod numeric(6),
descricao varchar(200) not null,
localizacao varchar(200),
primary key (cod));

create sequence seqfuncionario;

create table funcionario (
cod numeric(6),
nome varchar(200) not null,
cargo varchar(100),
dtcontratacao timestamp not null,
codgerente numeric(6),
salario numeric(12,2),
coddepartamento numeric(6),
primary key (cod),
foreign key (codgerente) references funcionario(cod),
foreign key (coddepartamento) references departamento(cod));


create table usuario (
    cod  numeric(6),
    login varchar(20) unique,
    senha varchar(200),
    primary key (cod));

insert into usuario values (1,'root','123');


-------------------------------------------- Java DB schema  ---------------------------------

create sequence seqdepartamento as INT start with 1;

create table departamento (
cod int,
descricao varchar(200) not null,
localizacao varchar(200),
primary key (cod));

create sequence seqfuncionario as INT start with 1;

create table funcionario (
cod int,
nome varchar(200) not null,
cargo varchar(100),
dtcontratacao timestamp not null,
codgerente int,
salario numeric(12,2),
coddepartamento int,
primary key (cod),
foreign key (codgerente) references funcionario(cod),
foreign key (coddepartamento) references departamento(cod));


create table usuario (
    cod  int,
    login varchar(20) unique,
    senha varchar(200),
    primary key (cod));

insert into usuario values (1,'root','123');


