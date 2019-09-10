package info.sjd.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.sjd.service.OrderService;
import info.sjd.service.impl.OrderServiceImpl;

public class RemoveServlet extends HttpServlet {
	
	private static final Logger LOG = Logger.getLogger(RemoveServlet.class.getName());
	private static OrderService orderService = new OrderServiceImpl();

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orderId = Integer.valueOf(req.getParameter("orderid"));
		
		if (orderId != 0) {
			orderService.delete(orderId);
			LOG.info("order deleted");
			
			resp.setStatus(200);
		} else {
			resp.setStatus(204);
		}
	}
}
