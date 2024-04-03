package com.edplus.controller;

import com.edplus.doc.movie.*;
import com.edplus.entity.dto.MovieCardDTO;
import com.edplus.entity.dto.MovieMainDTO;
import com.edplus.entity.dto.MovieRegisterDTO;
import com.edplus.entity.dto.MovieUpdateURLDTO;
import com.edplus.service.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
@Tag(name = "Movie", description = "movies operations")
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    @SwaggerMovieRegister.NewMovie
    public ResponseEntity<MovieCardDTO> registerMovie(@Valid @RequestBody MovieRegisterDTO movieRegisterDTO){
        return movieService.register(movieRegisterDTO);
    }

    @GetMapping("/{id}")
    @SwaggerMovieFindById.FindById
    public ResponseEntity<MovieMainDTO> searchMovieById(@PathVariable Long id){
        return movieService.queryId(id);
    }

    @PatchMapping("/{id}")
    @SwaggerMovieUpdateURL.UpdateURLs
    public ResponseEntity<MovieCardDTO> updatingURL(@Valid @RequestBody MovieUpdateURLDTO movieUpdateURLDTO, @PathVariable Long id){
        return movieService.updateURL(movieUpdateURLDTO, id);
    }

    @GetMapping
    @SwaggerMovieReturnAll.ReturnALlMovies
    public ResponseEntity<List<MovieCardDTO>> allMovies(){
        return movieService.allMovies();
    }

    @GetMapping("/search")
    @SwaggerMovieSearch.SearchOnMovie
    public ResponseEntity<List<MovieCardDTO>> search(String param){
        return movieService.search(param);
    }
}
