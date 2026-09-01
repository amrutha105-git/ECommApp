package com.ecomm.user.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProfileDto {
	
	private Integer profileId;
	
	private String firstName;
	
    private String lastName;
	
	private String phone;
	
	private LocalDateTime dob;

}
