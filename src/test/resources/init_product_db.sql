drop table products;

create table products (
	id smallserial not null primary key,
	title varchar(255) not null,
	price real not null,
	description varchar
);

insert into products(title, price, description) values ('product1', 10.1, 'about product 1');
insert into products(title, price, description) values ('product2', 20.2, 'about product 2');
insert into products(title, price, description) values ('product3', 30.3, 'about product 3');