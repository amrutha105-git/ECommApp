package com.ecomm.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecomm.user.dto.UserDto;
import com.ecomm.user.entity.User;
import com.ecomm.user.exception.AppException;
import com.ecomm.user.repo.UserRepository;
import com.ecomm.user.request.LoginRequest;
import com.ecomm.user.request.RegisterRequest;
import com.ecomm.user.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UserDto register(RegisterRequest request) {
		//check whether user acc alreadyu exists or not
		User alreadyExists=urepo.findByEmail(request.getEmail()).orElse(null);
		if(alreadyExists!=null) {
			throw new RuntimeException("User alreqady exists!");
		}
		
		//transfering the data from request to entity and storing entity to db
		User newUser=mapper.map(request,User.class);
		newUser=urepo.save(newUser);
		
		return mapper.map(newUser,UserDto.class);
	}
	@Override
	public UserDto login(LoginRequest request) {
		//email validation
		User alreadyExists=urepo.findByEmail(request.getEmail()).orElseThrow(()->new RuntimeException("user not found"));
		
		//password validation
		if(!alreadyExists.getPassword().equals(request.getPassword())) {
			throw new AppException("Incorrect password!",HttpStatus.BAD_REQUEST);
		}
		
		return mapper.map(alreadyExists,UserDto.class);
	}

}
