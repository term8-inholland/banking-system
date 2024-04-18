drop table if exists bank_user;

create table bank_user (
    id uuid default random_uuid() not null primary key,
    first_name varchar(50) not null,
    last_name varchar(50),
    password varchar(255) not null
);

create table account (
    id uuid not null primary key,
    user_id int,
    foreign key (id) references bank_user(id)
);