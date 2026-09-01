package com.ecomm.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecomm.user.dto.RoleDto;
import com.ecomm.user.entity.Role;
import com.ecomm.user.enumm.RoleType;
import com.ecomm.user.exception.AppException;
import com.ecomm.user.repo.RoleRepository;
import com.ecomm.user.request.AddRoleRequest;
import com.ecomm.user.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository rlrepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public RoleDto addRole(AddRoleRequest request) {
		Role alreadyExist=rlrepo.findByRoleName(request.getRoleName()).orElse(null);
		if(alreadyExist!=null) {
			throw new AppException("Role already exist",HttpStatus.CONFLICT);
		}
		Role role=mapper.map(request,Role.class);
		role=rlrepo.save(role);
		return  mapper.map(role,RoleDto.class);
	}

	@Override
	public RoleDto getByRoleName(RoleType roleName) {
		
		return null;
	}

}
