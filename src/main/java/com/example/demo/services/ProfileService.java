package com.example.demo.services;

import com.example.demo.dto.ProfileDTO;
import com.example.demo.models.Profile;

public class ProfileService {

    public Profile createProfile(ProfileDTO profileDTO) {

        Profile profile = Profile.builder()
                .name(profileDTO.getName())
                .languages(profileDTO.getLanguages())
                .build();

        //TODO Create the profile entity on the database

        return profile;
    }

}
