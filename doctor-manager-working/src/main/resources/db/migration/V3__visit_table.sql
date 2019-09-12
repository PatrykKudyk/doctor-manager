create table visit (
    id bigint not null auto_increment,
    doctorId bigint not null,
    patientId bigint not null,
    date timestamp not null,
    duration int not null,
    visit_type varchar(255) not null,
    price int not null,
    constraint fk_doctor foreign key(doctorId)
    references doctor(id)
    on delete cascade
    on update cascade,
    constraint fk_patient foreign key(patientId)
    references patient(id)
    on delete cascade
    on update cascade,
    primary key(id)
)