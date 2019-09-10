drop table users;

create table users (
	id smallserial not null primary key,
	username varchar(255) not null,
	password varchar(255) not null
);

insert into users(username, password) values ('user1', 'pass11');
insert into users(username, password) values ('user2', 'pass22');
insert into users(username, password) values ('user3', 'pass33');