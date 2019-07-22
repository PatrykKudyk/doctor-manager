create table patient (
    id bigint not null auto_increment,
    name varchar(255) not null,
    lastname varchar(255) not null,
    date date not null,
    email varchar(255) not null,
    primary key(id)
)