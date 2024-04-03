package com.edplus.controller;

import com.edplus.doc.SwaggerGenre;
import com.edplus.entity.Genre;
import com.edplus.entity.dto.genre.GenreRegisterDTO;
import com.edplus.service.GenreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/genres")
@Tag(name = "Genre", description = "operations for genres")
public class GenreController {

    private final GenreService genreService;

    @PostMapping
    @SwaggerGenre.NewGenre
    public ResponseEntity<Genre> registration(@Valid @RequestBody GenreRegisterDTO genre){
        return genreService.register(genre);
    }

    @GetMapping("/{id}")
    @SwaggerGenre.FindByIdGenre
    public ResponseEntity<Genre> byId(@PathVariable  Long id){
        return genreService.byId(id);
    }

    @GetMapping
    @SwaggerGenre.ReturnALlGenres
    public ResponseEntity<List<Genre>> allGenres(){
        return genreService.allGenres();
    }

    @PatchMapping("/{id}")
    @SwaggerGenre.UpdateGenreName
    public ResponseEntity<Genre> updateName(@Valid @RequestBody GenreRegisterDTO genre, @PathVariable Long id){
        return genreService.updateName(genre, id);
    }
}
