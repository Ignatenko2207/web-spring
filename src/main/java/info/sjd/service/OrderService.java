package info.sjd.service;

import java.util.List;

import info.sjd.model.Order;

public interface OrderService {
	
	void insert(Order order);
	List<Order> getAll();
	List<Order> getOrdersByCartId(int id);
	Order getOneById(int id);
	void update(Order order);
	void delete(int id);
}
