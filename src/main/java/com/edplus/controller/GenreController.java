package com.edplus.controller;

import com.edplus.entity.Genre;
import com.edplus.service.GenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/genres")
public class GenreController {

    private final GenreService genreService;

    @PostMapping
    public ResponseEntity<Genre> registration(@Valid @RequestBody Genre genre){
        return genreService.register(genre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> byId(@PathVariable  Long id){
        return genreService.byId(id);
    }

    @GetMapping
    public ResponseEntity<List<Genre>> allGenres(){
        return genreService.allGenres();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Genre> updateName(@Valid @RequestBody Genre genre, @PathVariable Long id){
        return genreService.updateName(genre, id);
    }
}
