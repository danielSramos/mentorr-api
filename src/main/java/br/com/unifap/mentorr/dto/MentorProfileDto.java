package br.com.unifap.mentorr.dto;

import lombok.Data;

import java.util.List;

@Data
public class MentorProfileDto {

    private Long id;
    private String name;
    private String email;
    private String description;
    private Float rating;
    private List<String> skills;
    private String role;
    private String company;
    private String nationality;
    private String profileImageBase64;

}
