package info.sjd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import info.sjd.model.Order;

public class OrderDAO {

	private final static Logger LOG = Logger.getLogger(OrderDAO.class.getName());

	public static void insert(Order order) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		
		try {
			connection = ConnectionAndStatementFactory.connecting();

			LOG.info("inserting into orders table...");
			statement = ConnectionAndStatementFactory.createStatement(connection);

			String sql = "INSERT INTO orders (productid, quantity, cartid) VALUES ( " + order.getProductId()
					+ " , " + order.getQuantity() + ", " + order.getCartId() + ")";

			statement.execute(sql);
			LOG.info("insertion complete");
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static List<Order> getAll() throws SQLException {
		Statement statement = null;
		Connection connection = null;
		List<Order> result = new ArrayList<>();

		try {
			connection = ConnectionAndStatementFactory.connecting();

			LOG.info("reading from orders table...");
			statement = ConnectionAndStatementFactory.createStatement(connection);

			String SQL = "SELECT * FROM orders";

			ResultSet resultSet = statement.executeQuery(SQL);
			LOG.info("reading completed");

			while (resultSet.next()) {
				try {
					result.add(createOrder(resultSet));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return result;
	}

	public static List<Order> getOrdersByCartId(int id) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		List<Order> result = new ArrayList<>();

		try {
			connection = ConnectionAndStatementFactory.connecting();

			LOG.info("reading from orders table...");
			statement = ConnectionAndStatementFactory.createStatement(connection);

			String SQL = "SELECT * FROM orders WHERE cartid = " + id;

			ResultSet resultSet = statement.executeQuery(SQL);
			LOG.info("reading completed");

			while (resultSet.next()) {
				try {
					result.add(createOrder(resultSet));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return result;
	}

	public static void updateById(Order order) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		
		try {
			connection = ConnectionAndStatementFactory.connecting();

			LOG.info("updating orders table...");
			statement = ConnectionAndStatementFactory.createStatement(connection);

			String SQL = "UPDATE orders SET productid = " + order.getProductId() + ", quantity = "
					+ order.getQuantity() + ", cartid = " + order.getCartId() + " WHERE id = " + order.getId();

			statement.execute(SQL);
			LOG.info("update complete");
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static void delete(int id) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		
		try {
			connection = ConnectionAndStatementFactory.connecting();

			LOG.info("deleting from orders table...");
			statement = ConnectionAndStatementFactory.createStatement(connection);

			String SQL = "DELETE FROM orders WHERE id = " + id;

			statement.execute(SQL);
			LOG.info("deleting complete");
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static Order getOneById(int id) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		Order order = new Order();

		try {
			connection = ConnectionAndStatementFactory.connecting();

			LOG.info("seaching by id through orders table...");
			statement = ConnectionAndStatementFactory.createStatement(connection);

			String SQL = "SELECT * FROM orders WHERE id = " + id + "LIMIT 1";

			ResultSet resultSet = statement.executeQuery(SQL);

			if (resultSet.next())
				order = createOrder(resultSet);
			LOG.info("seaching complete");
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return order;
	}

	private static Order createOrder(ResultSet resultSet) throws SQLException {
		Order order = new Order();

		order.setId(resultSet.getInt("id"));
		order.setProductId(resultSet.getInt("productid"));
		order.setQuantity(resultSet.getInt("quantity"));
		order.setCartId(resultSet.getInt("cartid"));

		return order;
	}
}
