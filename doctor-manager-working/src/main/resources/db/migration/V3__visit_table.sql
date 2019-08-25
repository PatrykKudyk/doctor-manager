create table visit (
    id bigint not null auto_increment,
    doctor int not null,
    patient int,
    date date not null,
    duration int not null,
    visitType varchar not null,
    price int not null,
    primary key(id)
)