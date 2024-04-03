package com.edplus.controller;

import com.edplus.doc.SwaggerDirector;
import com.edplus.entity.Director;
import com.edplus.entity.dto.director.DirectorRegisterDTO;
import com.edplus.service.DirectorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/directors")
@Tag(name = "Director", description = "operations for directors")
public class DirectorController {

    private final DirectorService directorService;

    @PostMapping
    @SwaggerDirector.NewDirector
    public ResponseEntity<Director> registration(@Valid @RequestBody DirectorRegisterDTO director){
        return directorService.register(director);
    }

    @GetMapping("/{id}")
    @SwaggerDirector.FindByIdDirector
    public ResponseEntity<Director> byId(@PathVariable  Long id){
        return directorService.byId(id);
    }

    @GetMapping
    @SwaggerDirector.ReturnALlDirectors
    public ResponseEntity<List<Director>> allDirectors(){
        return directorService.allDirectors();
    }

    @PatchMapping("/{id}")
    @SwaggerDirector.UpdateDirectorName
    public ResponseEntity<Director> updateName(@Valid @RequestBody DirectorRegisterDTO director, @PathVariable Long id){
        return directorService.updateName(director, id);
    }
}
