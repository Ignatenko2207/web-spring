package info.sjd.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.sjd.model.Cart;
import info.sjd.model.Order;
import info.sjd.model.enums.Status;
import info.sjd.service.CartService;
import info.sjd.service.OrderService;
import info.sjd.service.impl.CartServiceImpl;
import info.sjd.service.impl.OrderServiceImpl;

public class OrderServlet extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(OrderServlet.class.getName());
	private static OrderService orderService = new OrderServiceImpl();
	private static CartService cartService = new CartServiceImpl();
	private static Cart cart = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartId = req.getParameter("cartid");
		LOG.info("Cart ID is " + cartId);
		cart = validateCart(Integer.valueOf(cartId));
		Order order = new Order();

		order.setCartId(cart.getId());
		order.setProductId(Integer.valueOf(req.getParameter("productid")));
		order.setQuantity(Integer.valueOf(req.getParameter("quantity")));

		LOG.info("creating new order...");
		orderService.insert(order);
		
		if (cart == null || cartId == null) {
			resp.setStatus(400);
		}

		resp.setStatus(201);

	}

	private static Cart validateCart(int id) {
		Cart cart = cartService.getOneById(id);

		if (cartService.validateCart(cart)) {
			return cart;
		} else {
			Cart newCart = new Cart();

			LOG.info("initializing new cart...");
			newCart.setUserId(cart.getUserId());
			newCart.setStatus(Status.OPEN);
			newCart.setTime(System.currentTimeMillis());

			cartService.createCart(newCart);
			newCart = cartService.getCartsByUserIdAndOpen(newCart.getUserId());

			LOG.info(newCart.toString());

			return newCart;
		}
	}

	public static Cart getCart() {
		return cart;
	}
}
