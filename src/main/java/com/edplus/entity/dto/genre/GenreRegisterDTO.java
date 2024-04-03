package com.edplus.entity.dto.genre;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class GenreRegisterDTO {

    @Column(nullable = false, unique = true)
    @NotBlank(message = "must have not be null")
    @Size(min = 3, message = "must have at least {min} characters")
    private String name;
}
