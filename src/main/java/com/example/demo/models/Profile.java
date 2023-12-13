package com.example.demo.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Profile {
    private String name;
    private List<String> languages;
}
