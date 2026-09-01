package com.ecomm.user.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class ClodinaryConfig {
	
	@Value("${cloudinary.cloud-name}")
	private String cloud_name;
	
	@Value("${cloudinary.api-key}")
	private String api_key;
	
	@Value("${cloudinary.api-secret}")
	private String api_secret;
	
	public Cloudinary cloud() {
		Map<String, Object>cloudmap=new HashMap<>();
		cloudmap.put("cloud_name",cloud_name );
		cloudmap.put("api_key",api_key );
		cloudmap.put("api_secret",api_secret );
		return  new Cloudinary(cloudmap);
		
	}
	


}
