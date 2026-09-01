package com.ecomm.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.user.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
