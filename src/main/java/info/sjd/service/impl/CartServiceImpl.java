package info.sjd.service.impl;

import java.util.List;
import java.util.logging.Logger;

import info.sjd.dao.CartDAO;
import info.sjd.model.Cart;
import info.sjd.model.enums.Status;
import info.sjd.service.CartService;

public class CartServiceImpl implements CartService {

	private static final Logger LOG = Logger.getLogger(CartServiceImpl.class.getName());

	@Override
	public void createCart(Cart cart) {
		CartDAO.insertCart(cart);
	}

	@Override
	public List<Cart> getAll() {
		return CartDAO.getAll();
	}

	@Override
	public Cart getOneById(int id) {
		return CartDAO.getOneById(id);
	}

	@Override
	public void update(Cart cart) {
		CartDAO.updateCart(cart);
	}

	@Override
	public void delete(Cart cart) {
		CartDAO.deleteCart(cart);
	}

	@Override
	public List<Cart> getCartsByTime(long from, long till) {
		return CartDAO.getCartsByTime(from, till);
	}

	@Override
	public List<Cart> getCartsByUserId(int id) {
		return CartDAO.getCartsByUserId(id);
	}

	@Override
	public Cart getCartsByUserIdAndOpen(int id) {
		return CartDAO.getCartByUserIdAndOpen(id);
	}

	@Override
	public void checkout(int id) {
		Cart cartToClose = CartDAO.getOneById(id);
		cartToClose.setStatus(Status.CLOSED);
		CartDAO.updateCart(cartToClose);
	}

	@Override
	public boolean validateCart(Cart cart) {
		Cart cartToCheck = null;

		cartToCheck = CartDAO.getOneById(cart.getId());

		if (cartToCheck != null && cartToCheck.getStatus().equals(Status.OPEN)) {
			LOG.info(cartToCheck.toString());
			return true;
		}

		return false;
	}
}
