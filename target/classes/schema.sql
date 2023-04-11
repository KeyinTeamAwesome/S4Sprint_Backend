--CREATE TABLE public.movie (
--  id INT4 NULL,
--  title VARCHAR(200) NULL,
--  genre VARCHAR(200) NULL,
--  review INT4 NULL,
--  CONSTRAINT movie_pkey PRIMARY KEY (id)
--)
drop table if exists movie;
create table movie (
id integer not null auto_increment,
genre varchar(255) not null,
review integer not null,
title varchar(255) not null,
year integer not null,
primary key (id)
)
