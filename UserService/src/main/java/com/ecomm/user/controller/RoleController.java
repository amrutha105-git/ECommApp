package com.ecomm.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.user.dto.RoleDto;
import com.ecomm.user.request.AddRoleRequest;
import com.ecomm.user.response.ApiResponse;
import com.ecomm.user.service.RoleService;

@RestController
@RequestMapping("/Role")
public class RoleController {
	
	@Autowired
	private RoleService rservice;
	
	@PostMapping("/addRole")
	public ResponseEntity<?> addRole(@RequestBody AddRoleRequest request){
		RoleDto dto=rservice.addRole(request);
		return ResponseEntity.ok(new ApiResponse<>("role added",dto,HttpStatus.OK));
	}

}
