package com.edplus.service;

import com.edplus.entity.Director;
import com.edplus.entity.dto.director.DirectorRegisterDTO;
import com.edplus.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;
    private DirectorRepository dirc;

    @Transactional
    public ResponseEntity<Director> register(DirectorRegisterDTO director){
        return ResponseEntity.status(HttpStatus.CREATED).body(directorRepository.save(new Director(director.getName())));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Director>> allDirectors(){
        return ResponseEntity.ok().body(directorRepository.findAll());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Director> byId(Long id){
        Optional<Director> director = directorRepository.findById(id);
        return ResponseEntity.ok().body(director.get());
    }

    @Transactional
    public ResponseEntity<Director> updateName(DirectorRegisterDTO director, Long id){
        Optional<Director> d = directorRepository.findById(id);
        d.get().setName(director.getName().toUpperCase());
        return ResponseEntity.ok().body(d.get());
    }
}
