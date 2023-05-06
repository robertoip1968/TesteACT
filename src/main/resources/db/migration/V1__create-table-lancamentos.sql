create table lancamentos(

    id bigint not null auto_increment,
    idcliente bigint not null,
    datalancamento datetime not null,
    tipolancamento varchar(1) not null,
    valorlancamento double(12,2) not null,
    ativo tinyint,

    primary key(id)

);