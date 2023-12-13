package com.example.demo.rest;

import com.example.demo.dto.ProfileDTO;
import com.example.demo.models.Profile;
import com.example.demo.services.ProfileService;
import com.example.demo.utils.ProfileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@Controller
public class BasicController {

    @Autowired
    private ProfileUtils profileUtils;

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public ResponseEntity<Profile> createProfile(@RequestBody ProfileDTO profileDTO) {
        profileUtils.validateInput(profileDTO);
        try {
            Profile profile = profileService.createProfile(profileDTO);
            return ResponseEntity.created(URI.create("/" + profile.getName())).body(profile);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
