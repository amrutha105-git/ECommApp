package com.ecomm.user.service;

import com.ecomm.user.dto.UserDto;
import com.ecomm.user.request.RegisterRequest;

public interface UserService {

	UserDto register(RegisterRequest request);
}
