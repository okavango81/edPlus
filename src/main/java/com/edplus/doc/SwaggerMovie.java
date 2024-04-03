package com.edplus.doc;

import com.edplus.entity.dto.movie.MovieCardDTO;
import com.edplus.entity.dto.movie.MovieMainDTO;
import com.edplus.exception.ObjectException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class SwaggerMovie {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Operation(
            summary = "Registration",
            description = "Method to register new movie",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Resource created successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieCardDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Malformed request syntax",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ObjectException.class))
                    ),
                    @ApiResponse(responseCode = "409", description = "This title is already registered in the database",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ObjectException.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Validation of the supplied argument(s) failed",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ObjectException.class))
                    )
            }
    )
    public @interface NewMovie{}


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Operation(
            summary = "Find by id",
            description = "Method to find movie by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All details for movie",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieMainDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Malformed request syntax",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ObjectException.class))
                    )
            }
    )
    public @interface FindById{}


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


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Operation(
            summary = "Update URLs",
            description = "Method for updating the movie's main image and card URLs",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Updated URLs",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieCardDTO.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Unable to process the content contained in the instruction",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ObjectException.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Malformed request syntax",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ObjectException.class))
                    )
            }
    )
    public @interface UpdateURLs{}
}
