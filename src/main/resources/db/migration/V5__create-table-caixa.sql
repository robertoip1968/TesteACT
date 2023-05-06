create table caixas(
    idcaixa bigint not null auto_increment,
    saldo double(12,2) not null,
    flagativo tinyint,
    datacriacao datetime not null,

    primary key(idcaixa)

);