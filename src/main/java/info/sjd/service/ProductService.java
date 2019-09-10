package info.sjd.service;

import java.util.List;

import info.sjd.model.Product;
import info.sjd.utilities.ProductTO;

public interface ProductService {

	void insert(Product product);
	List<Product> getAll();
	List<ProductTO> getAllProductsByCartId(int id);
	List<ProductTO> getProductsHistoryByTimeAndUserId(int userId, long from, long till);
	Product getOneById(int id);
	void update(Product product);
	void delete(Product product);
}
