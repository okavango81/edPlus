package com.edplus.controller;

import com.edplus.entity.Character;
import com.edplus.service.CharacterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/characters")
public class CharacterController {

    private final CharacterService characterService;

    @PostMapping
    public ResponseEntity<Character> registration(@Valid @RequestBody Character character){
        return characterService.register(character);
    }

    @GetMapping
    public ResponseEntity<List<Character>> returnAll(){
        return characterService.all();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> findById(@PathVariable Long id){
        return characterService.searchById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Character> updateName(@Valid @RequestBody Character character, @PathVariable Long id){
        return characterService.update(character, id);
    }



}
