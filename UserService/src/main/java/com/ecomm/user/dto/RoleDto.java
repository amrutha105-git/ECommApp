package com.ecomm.user.dto;

import com.ecomm.user.enumm.RoleType;

import lombok.Data;

@Data
public class RoleDto {
	
	private Integer roleId;
	
	private RoleType roleName;

}
