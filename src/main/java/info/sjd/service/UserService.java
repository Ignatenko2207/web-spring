package info.sjd.service;

import java.util.List;

import info.sjd.model.User;

public interface UserService {

	void insert(User user);
	List<User> getAll();
	User getOneById(int id);
	User getOneByUsernamed(String username);
	void update(User user);
	void delete(User user);
}
