package com.jsp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.user.dao.UserDao;
import com.jsp.user.dto.User;
import com.jsp.user.service.UserService;
import com.jsp.user.utill.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody @Valid User user) {
		return service.saveUser(user);
		}
	
	
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<User>> findUserbyID(@RequestParam int userId) {
		return service.findUserById(userId);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam int id,@RequestBody User user) {
		return service.updateUser(id,user);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id) {
		return service.deleteUserbyId(id);
	}

	
	
	
	
	
	
//	@Autowired
//	private UserDao userDao;
//	
//	@PostMapping("/save")
//	public User saveUser(@RequestBody User user) {
//		return userDao.saveUser(user);
//	}
//	
//	@GetMapping("/find")
//	public User findUserbyID(@RequestParam int userId) {
//		return userDao.findUserById(userId);
//	}
//	
//	@PutMapping("/update")
//	public User updateUser(@RequestParam int id,@RequestBody User user) {
//		return userDao.updateUser(id,user);
//	}
//	
//	@DeleteMapping("/delete")
//	public User deleteUser(@RequestParam int id) {
//		return userDao.deleteUserbyId(id);
//	}
}
