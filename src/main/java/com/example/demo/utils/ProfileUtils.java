package com.example.demo.utils;

import com.example.demo.dto.ProfileDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ProfileUtils {
    public void validateInput(ProfileDTO profileDTO) {
        if (StringUtils.isEmpty(profileDTO.getName())) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "empty name");
        }
        if (CollectionUtils.isEmpty(profileDTO.getLanguages())) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "languages empty");
        }
        if (profileDTO.getLanguages().contains("ita")) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "ita detected, not good");
        }
    }
}
