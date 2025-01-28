package br.com.unifap.mentorr.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@JsonInclude(NON_NULL)
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private int statusCode;
    private String error;
    private Map<String, Object> fields;

}
