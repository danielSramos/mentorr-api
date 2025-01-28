package br.com.unifap.mentorr.dto;

import br.com.unifap.mentorr.entity.Nationality;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    private String shortDescription;
    @NotNull
    private Nationality nationality;
    @NotEmpty
    private String role;

}
