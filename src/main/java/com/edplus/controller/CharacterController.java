package com.edplus.controller;

import com.edplus.doc.SwaggerCharacter;
import com.edplus.entity.Character;
import com.edplus.entity.dto.character.CharacterRegisterDTO;
import com.edplus.service.CharacterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/characters")
@Tag(name = "Character", description = "operations for characters")
public class CharacterController
{

    private final CharacterService characterService;

    @PostMapping
    @SwaggerCharacter.NewCharacter
    public ResponseEntity<Character> registration(@Valid @RequestBody CharacterRegisterDTO character)
    {
        return characterService.register(character);
    }

    @GetMapping
    @SwaggerCharacter.ReturnALlCharacters
    public ResponseEntity<List<Character>> returnAll()
    {
        return characterService.all();
    }

    @GetMapping("/{id}")
    @SwaggerCharacter.FindByIdCharacter
    public ResponseEntity<Character> findById(@PathVariable Long id)
    {
        return characterService.searchById(id);
    }

    @PatchMapping("/{id}")
    @SwaggerCharacter.UpdateCharacterName
    public ResponseEntity<Character> updateName(@Valid @RequestBody CharacterRegisterDTO character, @PathVariable Long id)
    {
        return characterService.update(character, id);
    }

}
