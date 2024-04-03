package com.edplus.doc.movie;

import com.edplus.entity.dto.MovieCardDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class SwaggerMovieReturnAll {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Operation(
            summary = "Return all",
            description = "Method to return all movies",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Return of all registered movies",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieCardDTO.class))
                    )
            }
    )

    public @interface ReturnALlMovies{}
}
