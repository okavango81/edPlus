package com.edplus.entity.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Getter
@Data
public class MovieRegisterDTO {

    @NotBlank(message = "must not be null")
    @Size(min = 2, message = "must have at least {min} characters")
    private String title;

    @NotBlank(message = "must not be null")
    @Min(value = 1, message = "must be greater than 0 (zero)")
    @Max(value = 270, message = "The maximum number must be {value}")
    private String minutes;

    private String duration;

    @NotBlank(message = "must not be null")
    @Min(value = 1922, message = "must be equal to or greater than {value}")
    @Max(value = 2024, message = "must be equal to or less than {value}")
    private String releaseYear;

    @NotBlank(message = "must not be null")
    @Pattern(regexp = "^(l|L|10|12|16|18)$", message = "The allowed values are: L,10,12,16,18")
    private String classification;

    private String cardURL;

    private String mainURL;

    @NotBlank(message = "must not be null")
    @Size(min = 15, message = "must have at least {min} characters")
    private String synopsis;

}
