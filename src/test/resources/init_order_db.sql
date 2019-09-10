drop table orders;

create table orders (
	id smallserial not null primary key,
	productId int not null,
	quantity int not null,
	cartId int not null
);

insert into orders(productid, quantity, cartid) values (11, 1, 111);
insert into orders(productid, quantity, cartid) values (22, 2, 222);
insert into orders(productid, quantity, cartid) values (33, 3, 333);