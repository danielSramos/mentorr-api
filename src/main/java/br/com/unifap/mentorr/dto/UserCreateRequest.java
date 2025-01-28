package br.com.unifap.mentorr.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 200)
    private String password;

    @NotNull
    @Min(1)
    @Max(10)//depois precisa ver como deixar esse tamanho dinâmico para crescer de acordo com a quantidade de nacionalidades disponívels no banco de dados.
    private Long nationalityId;

    @NotNull
    @Min(1)
    @Max(8)
    private Long roleId;

}
