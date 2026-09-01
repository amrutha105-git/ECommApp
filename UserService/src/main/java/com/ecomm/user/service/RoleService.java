package com.ecomm.user.service;

import com.ecomm.user.dto.RoleDto;
import com.ecomm.user.enumm.RoleType;
import com.ecomm.user.request.AddRoleRequest;

public interface RoleService {
	
	 public RoleDto addRole(AddRoleRequest request);
	 
	 public RoleDto getByRoleName(RoleType roleName);
	
	

}
