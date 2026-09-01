package com.ecomm.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.user.request.UpdateProfileRequest;
import com.ecomm.user.response.CloudinaryResponse;
import com.ecomm.user.dto.ProfileDto;
import com.ecomm.user.entity.Profile;
import com.ecomm.user.exception.AppException;
import com.ecomm.user.repo.ProfileRepository;
import com.ecomm.user.service.CloudinaryService;
import com.ecomm.user.service.ProfileService;
@Service
public class ProfileServiceImpl implements ProfileService {
	
	
	@Autowired
	private ProfileRepository prepo;
	
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CloudinaryService cservice;
	

	@Override
	public ProfileDto addProfile(Profile profile) {
		if(profile.getProfileId()!=null && prepo.existsById(profile.getProfileId())) {
			throw new AppException(" The profile already Exists!",HttpStatus.CONFLICT);
			
		}
		Profile newProfile=mapper.map(profile, Profile.class);
		prepo.save(newProfile);
		
		ProfileDto dto=mapper.map(newProfile, ProfileDto.class);
		
		return dto;
	}

	@Override
	public ProfileDto getProfileById(Integer profileId) {
    Profile profile=prepo.findById(profileId)
    		.orElseThrow(()->new AppException("Profile not found!",HttpStatus.NOT_FOUND));
		
		ProfileDto dto=mapper.map(profile,ProfileDto.class);
		return dto;
	}

	@Override
	public ProfileDto updateProfile(Integer profleId, UpdateProfileRequest request, MultipartFile image) {
		CloudinaryResponse response=null;
		Profile exists=prepo.findById(profleId).orElseThrow(()->new AppException("profile not found!", HttpStatus.NOT_FOUND));
		mapper.map(request, exists);
		if(image!=null && !image.isEmpty()) {
			if(exists.getPublicId()!=null) {
			 cservice.deleteImage(exists.getPublicId());
			}
			response=cservice.uploadImage(image);
			exists.setImageURL(response.getImageUrl());
			exists.setPublicId(response.getPublicId());
		}
		exists=prepo.save(exists);
		return mapper.map(exists, ProfileDto.class);
	}

}
