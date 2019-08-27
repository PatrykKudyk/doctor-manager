create table visit (
    id bigint not null auto_increment,
    doctorID int not null,
    patientID int not null,
    date date not null,
    duration int not null,
    visitType varchar(255) not null,
    price int not null,
    primary key(id)
)