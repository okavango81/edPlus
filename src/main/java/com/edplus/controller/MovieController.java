package com.edplus.controller;

import com.edplus.entity.Movie;
import com.edplus.entity.dto.MovieCardDTO;
import com.edplus.entity.dto.MovieRegisterDTO;
import com.edplus.entity.dto.MovieUpdateURLDTO;
import com.edplus.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieCardDTO> registerMovie(@Valid @RequestBody MovieRegisterDTO movieRegisterDTO){
        return movieService.register(movieRegisterDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieCardDTO> searchMovieById(@PathVariable Long id){
        return movieService.queryId(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovieCardDTO> updatingURL(@Valid @RequestBody MovieUpdateURLDTO movieUpdateURLDTO, @PathVariable Long id){
        return movieService.updateURL(movieUpdateURLDTO, id);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return movieService.allMovies();
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieCardDTO>> search(String param){
        return movieService.search(param);
    }
}
