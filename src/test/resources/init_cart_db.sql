drop table carts;

create table carts (
	id smallserial not null primary key,
	userId int not null,
	status varchar(255),
	timestamp bigint
);

insert into carts(userid, status, timestamp) values (111, 'OPEN', 1560290002235);
insert into carts(userid, status, timestamp) values (222, 'OPEN', 1560290002245);
insert into carts(userid, status, timestamp) values (333, 'OPEN', 1560290002255);