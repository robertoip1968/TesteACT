create table contas(
    idconta bigint not null auto_increment,
    idpessoa bigint not null,
    saldo double(12,2) not null,
    limitesaquediario double(12,2) not null,
    flagativo tinyint,
    tipo varchar(1) not null,
    datacriacao datetime not null,

    primary key(idconta)

);