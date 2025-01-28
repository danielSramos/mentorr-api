package br.com.unifap.mentorr.dto;

import lombok.Data;

import java.util.List;

@Data
public class MentorListDto {

    private String name;
    private String position;
    private String company;
    private Float rating;
    private String shortDescription;
    private String profileImageBase64;
    private List<String> userSkills;

}
