drop table if exists movie;
create table movie (
id integer not null auto_increment,
genre varchar(255) not null,
review integer not null,
title varchar(255) not null,
primary key (id)
)

