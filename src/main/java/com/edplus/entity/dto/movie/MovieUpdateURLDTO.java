package com.edplus.entity.dto.movie;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MovieUpdateURLDTO {

    @NotBlank(message = "must have not be null")
    @Size(min = 7, message = "must be at least {min} characters")
    private String cardURL;

    @NotBlank(message = "must have not be null")
    @Size(min = 7, message = "must be at least {min} characters")
    private String mainURL;
}
