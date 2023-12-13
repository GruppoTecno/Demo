package com.example.demo.utils;

import com.example.demo.models.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

public class ProfileUtils {
    public void validateInput(Profile profile) {
        if (StringUtils.isEmpty(profile.getName())) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "empty name");
        }
        if (CollectionUtils.isEmpty(profile.getLanguages())) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "languages empty");
        }

        //TODO check if in languages there is 'ita', if so, throw an exception

    }
}
