package com.edplus.doc;

import com.edplus.entity.Director;
import com.edplus.entity.Genre;
import com.edplus.exception.ObjectException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class SwaggerGenre {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Operation(
            summary = "Registration",
            description = "Method to register new genre",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Resource created successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Genre.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Malformed request syntax",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ObjectException.class))
                    ),
                    @ApiResponse(responseCode = "409", description = "This name is already registered in the database",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ObjectException.class))
                    ),
                    @ApiResponse(responseCode = "422", description = "Validation of the supplied argument(s) failed",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ObjectException.class))
                    )
            }
    )
    public @interface NewGenre{}


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Operation(
            summary = "Return all",
            description = "Method to return all genres",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Return of all registered genres",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Genre.class))
                    )
            }
    )

    public @interface ReturnALlGenres{}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Operation(
            summary = "Find by id",
            description = "Method to find genre by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All details for genre",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Genre.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Malformed request syntax",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ObjectException.class))
                    )
            }
    )
    public @interface FindByIdGenre{}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Operation(
            summary = "Update name",
            description = "Method for updating the name of genre",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Updated name",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Genre.class))
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
    public @interface UpdateGenreName{}
}
