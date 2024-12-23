package com.edplus.entity.dto.movie;

import jakarta.validation.constraints.*;

import lombok.Getter;

@Getter
public class MovieRegisterDTO {

    @NotBlank(message = "must not be null")
    @Size(min = 2, message = "must have at least {min} characters")
    private String title;

    @NotNull(message = "must not be null")
    @Min(value = 1, message = "must be greater than 0 (zero)")
    @Max(value = 270, message = "The maximum number must be {value}")
    private Integer minutes;


    @NotBlank(message = "must not be null")
    @Min(value = 1922, message = "must be equal to or greater than {value}")
    @Max(value = 2024, message = "must be equal to or less than {value}")
    private String releaseYear;

    @NotBlank(message = "must not be null")
    @Pattern(regexp = "^(l|L|10|12|14|16|18)$", message = "The allowed values are: L,10,12,14,16,18")
    private String classification;

    private String cardURL;

    private String mainURL;

    @NotBlank(message = "must not be null")
    @Size(min = 15, message = "must have at least {min} characters")
    private String synopsis;

}
