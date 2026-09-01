package com.ecomm.user.request;

import com.ecomm.user.enumm.RoleType;

import lombok.Data;

@Data
public class AddRoleRequest {
	
	private RoleType roleName;

}
