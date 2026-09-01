package com.ecomm.user.service;

import org.springframework.web.multipart.MultipartFile;

import com.ecomm.user.dto.ProfileDto;
import com.ecomm.user.entity.Profile;
import com.ecomm.user.request.UpdateProfileRequest;

public interface ProfileService {
	
	public ProfileDto addProfile(Profile profile);
	
	public ProfileDto getProfileById(Integer profileId);
	
	public ProfileDto updateProfile(Integer profleId, UpdateProfileRequest request, MultipartFile image);

}
