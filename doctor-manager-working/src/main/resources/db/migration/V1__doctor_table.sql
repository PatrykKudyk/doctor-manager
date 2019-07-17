create table doctor (
    id bigint not null auto_increment,
    name varchar(255) not null,
    lastname varchar(255) not null,
    specialization varchar(255) not null,
    rate int not null,
    primary key(id)
)