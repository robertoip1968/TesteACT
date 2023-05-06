create table transacoes(
    idtransacao bigint not null auto_increment,
    idconta bigint not null,
    valor double(12,2) not null,
    datatransacao datetime not null,

    primary key(idtransacao)

);