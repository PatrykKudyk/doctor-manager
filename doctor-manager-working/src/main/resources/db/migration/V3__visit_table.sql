create table visit (
    id bigint not null auto_increment,
    doctorID int not null,
    patientID int not null,
    date timestamp not null,
    duration int not null,
    visit_type varchar(255) not null,
    price int not null,
    primary key(id)
)