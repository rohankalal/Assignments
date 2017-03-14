-- Table definitions for the tournament project.
--
-- Put your SQL 'create table' statements in this file; also 'create view'
-- statements if you choose to use it.
--
-- You can write comments in this file by starting them with two dashes, like
-- these lines here.


create table players(id serial primary key,name varchar(50));

create table playerstandings (id int references players(id),name varchar(50) ,wins int,matches int);

create table swisspairings(id1 int references players(id), name1 varchar(50),id2 int references players(id), name2 varchar(50));

create table matches(id serial,PlayerId int references Players(id),OpponentId int referneces Players(Id),Winner int);

create table wins(id int references players(id),WinNum int);

