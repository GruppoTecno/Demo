package com.example.demo.services;

import com.example.demo.dto.ProfileDTO;
import com.example.demo.models.Profile;
import com.example.demo.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile createProfile(ProfileDTO profileDTO) {

        Profile profile = Profile.builder()
                .name(profileDTO.getName())
                .languages(profileDTO.getLanguages())
                .build();

        profileRepository.createProfile(profile);

        return profile;
    }

}
