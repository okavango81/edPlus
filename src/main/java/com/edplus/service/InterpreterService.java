package com.edplus.service;

import com.edplus.entity.Interpreter;
import com.edplus.entity.dto.interpreter.InterpreterRegisterDTO;
import com.edplus.repository.InterpreterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InterpreterService {

    private final InterpreterRepository interpreterRepository;


    @Transactional
    public ResponseEntity<Interpreter> register(InterpreterRegisterDTO interpreter){
        return ResponseEntity.status(HttpStatus.CREATED).body(interpreterRepository.save(new Interpreter(interpreter.getName())));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<Interpreter>> allInterpreters(){
        return ResponseEntity.ok().body(interpreterRepository.findAll());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Interpreter> byId(Long id){
        Optional<Interpreter> interpreter = interpreterRepository.findById(id);
        return ResponseEntity.ok().body(interpreter.get());
    }

    @Transactional
    public ResponseEntity<Interpreter> updateName(InterpreterRegisterDTO interpreter, Long id){
        Optional<Interpreter> i = interpreterRepository.findById(id);
        i.get().setName(interpreter.getName().toUpperCase());
        return ResponseEntity.ok().body(i.get());
    }
}
