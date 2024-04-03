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

public class SwaggerMovieSearch {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Operation(
            summary = "Search",
            description = "Search by any criteria of a movie",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Return of searching",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieCardDTO.class))
                    )
            }
    )
    public @interface SearchOnMovie{}
}
