create table pessoas(
    idpessoa bigint not null auto_increment,
    nome varchar (200) not null,
    cpf varchar (11) not null,
    datanascimento datetime not null,

    primary key(idpessoa)

);