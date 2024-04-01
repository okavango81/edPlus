package com.edplus.controller;

import com.edplus.entity.Director;
import com.edplus.service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/directors")
public class DirectorController {

    private final DirectorService directorService;

    @PostMapping
    public ResponseEntity<Director> registration(@Valid @RequestBody Director director){
        return directorService.register(director);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> byId(@PathVariable  Long id){
        return directorService.byId(id);
    }

    @GetMapping
    public ResponseEntity<List<Director>> allDirectors(){
        return directorService.allDirectors();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Director> updateName(@Valid @RequestBody Director director, @PathVariable Long id){
        return directorService.updateName(director, id);
    }
}
