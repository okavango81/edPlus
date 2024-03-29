package com.edplus.service;

import com.edplus.entity.Character;
import com.edplus.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Transactional
    public ResponseEntity<Character> register(Character character){
        return ResponseEntity.status(HttpStatus.CREATED).body(characterRepository.save(new Character(character.getName())));
    }

    @Transactional
    public ResponseEntity<List<Character>> all(){
        return ResponseEntity.ok().body(characterRepository.findAll());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Character> searchById(Long id){
        Optional<Character> character = characterRepository.findById(id);
        return ResponseEntity.ok().body(character.get());
    }

    @Transactional
    public ResponseEntity<Character> update(Character character, Long id){
        Optional<Character> c = characterRepository.findById(id);
        c.get().setName(character.getName().toUpperCase());
        return ResponseEntity.ok().body(c.get());
    }
}
