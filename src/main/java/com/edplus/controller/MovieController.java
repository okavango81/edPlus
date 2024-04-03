package com.edplus.controller;

import com.edplus.doc.SwaggerMovie;
import com.edplus.entity.dto.movie.MovieCardDTO;
import com.edplus.entity.dto.movie.MovieMainDTO;
import com.edplus.entity.dto.movie.MovieRegisterDTO;
import com.edplus.entity.dto.movie.MovieUpdateURLDTO;
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
@Tag(name = "Movie", description = "operations for movies")
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    @SwaggerMovie.NewMovie
    public ResponseEntity<MovieCardDTO> registerMovie(@Valid @RequestBody MovieRegisterDTO movieRegisterDTO){
        return movieService.register(movieRegisterDTO);
    }

    @GetMapping("/{id}")
    @SwaggerMovie.FindById
    public ResponseEntity<MovieMainDTO> searchMovieById(@PathVariable Long id){
        return movieService.queryId(id);
    }

    @PatchMapping("/{id}")
    @SwaggerMovie.UpdateURLs
    public ResponseEntity<MovieCardDTO> updatingURL(@Valid @RequestBody MovieUpdateURLDTO movieUpdateURLDTO, @PathVariable Long id){
        return movieService.updateURL(movieUpdateURLDTO, id);
    }

    @GetMapping
    @SwaggerMovie.ReturnALlMovies
    public ResponseEntity<List<MovieCardDTO>> allMovies(){
        return movieService.allMovies();
    }

    @GetMapping("/search")
    @SwaggerMovie.SearchOnMovie
    public ResponseEntity<List<MovieCardDTO>> search(String param){
        return movieService.search(param);
    }
}
