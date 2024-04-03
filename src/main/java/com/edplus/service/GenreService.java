package com.edplus.service;

import com.edplus.entity.Genre;
import com.edplus.entity.dto.genre.GenreRegisterDTO;
import com.edplus.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;


    @Transactional
    public ResponseEntity<Genre> register(GenreRegisterDTO genre){
        return ResponseEntity.status(HttpStatus.CREATED).body(genreRepository.save(new Genre(genre.getName())));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Genre>> allGenres(){
        return ResponseEntity.ok().body(genreRepository.findAll());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Genre> byId(Long id){
        Optional<Genre> genre = genreRepository.findById(id);
        return ResponseEntity.ok().body(genre.get());
    }

    @Transactional
    public ResponseEntity<Genre> updateName(GenreRegisterDTO genre, Long id){
        Optional<Genre> g = genreRepository.findById(id);
        g.get().setName(genre.getName().toUpperCase());
        return ResponseEntity.ok().body(g.get());
    }
}
