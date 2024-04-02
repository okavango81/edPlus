package com.edplus.controller;

import com.edplus.entity.Interpreter;
import com.edplus.service.InterpreterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/interpreters")
public class InterpreterController {

    private final InterpreterService interpreterService;

    @PostMapping
    public ResponseEntity<Interpreter> registration(@Valid @RequestBody Interpreter interpreter){
        return interpreterService.register(interpreter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interpreter> byId(@PathVariable  Long id){
        return interpreterService.byId(id);
    }

    @GetMapping
    public ResponseEntity<List<Interpreter>> allInterpreters(){
        return interpreterService.allInterpreters();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Interpreter> updateName(@Valid @RequestBody Interpreter interpreter, @PathVariable Long id){
        return interpreterService.updateName(interpreter, id);
    }
}
