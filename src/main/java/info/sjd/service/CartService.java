package info.sjd.service;

import java.util.List;

import info.sjd.model.Cart;

public interface CartService {

	void createCart(Cart cart);
	List<Cart> getAll();
	List<Cart> getCartsByTime(long from, long till);
	List<Cart> getCartsByUserId(int id);
	Cart getOneById(int id);
	Cart getCartsByUserIdAndOpen(int id);
	void update(Cart cart);
	void delete(Cart cart);
	void checkout(int id);
	boolean validateCart(Cart cart);
}
