package com.jsp.user.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.user.dto.User;
import com.jsp.user.repo.UserRepo;

@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User findUserById(int userId) {
		Optional< User>optional=repo.findById(userId);
		if(optional.isPresent()) {
			User user=optional.get();
			return user;
		}
		else {
			//		id not present
			return null;
		}
	}

	public User updateUser(int id, User user) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
			//		user is present
			user.setId(id);
			return repo.save(user);
		}
		return null;
	}

	public User deleteUserbyId(int id) {

		Optional< User>optional=repo.findById(id);
		if(optional.isPresent()) {
			User user=optional.get();
			repo.deleteById(id);
			return user;
		}
		else {
			//		id not present
			return null;
		}
	}
}
