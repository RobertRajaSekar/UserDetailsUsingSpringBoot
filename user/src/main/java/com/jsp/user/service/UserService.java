package com.jsp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.user.dao.UserDao;
import com.jsp.user.dto.User;
import com.jsp.user.exception.UserIdNotFoundException;
import com.jsp.user.utill.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser=dao.saveUser(user);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		responseStructure.setMessage("user Saved sucessfully");
		responseStructure.setHttpStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int userId) {
		User dbUser=dao.findUserById(userId);
		if(dbUser !=null) {
			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
			responseStructure.setMessage("user fetched sucessfully");
			responseStructure.setHttpStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
		}
		else {
			throw new UserIdNotFoundException("Sorry Failed to fetch the data");

			
//			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
//			responseStructure.setMessage("user Data Not Found");
//			responseStructure.setHttpStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setData(null);
//			return responseStructure;
		}
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User dbUser=dao.updateUser(id, user);
		if(dbUser!=null) {
			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
			responseStructure.setMessage("user updateded sucessfully");
			responseStructure.setHttpStatus(HttpStatus.OK.value());
			responseStructure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);	
		}
		else {
			throw new UserIdNotFoundException("Sorry Failed to update the data");

//			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
//			responseStructure.setMessage("user Data Not Found");
//			responseStructure.setHttpStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setData(null);
//			return responseStructure;
		}

	}

	public ResponseEntity<ResponseStructure<User>> deleteUserbyId(int id) {
		User dbUser=dao.deleteUserbyId(id);
		if(dbUser!=null) {
			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
			responseStructure.setMessage("user deleted sucessfully");
			responseStructure.setHttpStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);	
		}
		else {
			throw new UserIdNotFoundException("Sorry Failed to delete the data");
			
//			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
//			responseStructure.setMessage("user Data Not Found");
//			responseStructure.setHttpStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setData(null);
//			return responseStructure;
		}
	}
	
	



}
