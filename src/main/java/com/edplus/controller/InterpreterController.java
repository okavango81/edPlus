package com.edplus.controller;

import com.edplus.doc.SwaggerInterpreter;
import com.edplus.entity.Interpreter;
import com.edplus.entity.dto.interpreter.InterpreterRegisterDTO;
import com.edplus.service.InterpreterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/interpreters")
@Tag(name = "Interpreter", description = "operations for interpreters")
public class InterpreterController {

    private final InterpreterService interpreterService;

    @PostMapping
    @SwaggerInterpreter.NewInterpreter
    public ResponseEntity<Interpreter> registration(@Valid @RequestBody InterpreterRegisterDTO interpreter){
        return interpreterService.register(interpreter);
    }

    @GetMapping("/{id}")
    @SwaggerInterpreter.FindByIdInterpreter
    public ResponseEntity<Interpreter> byId(@PathVariable  Long id){
        return interpreterService.byId(id);
    }

    @GetMapping
    @SwaggerInterpreter.ReturnALlInterpreters
    public ResponseEntity<List<Interpreter>> allInterpreters(){
        return interpreterService.allInterpreters();
    }

    @PatchMapping("/{id}")
    @SwaggerInterpreter.UpdateInterpreterName
    public ResponseEntity<Interpreter> updateName(@Valid @RequestBody InterpreterRegisterDTO interpreter, @PathVariable Long id){
        return interpreterService.updateName(interpreter, id);
    }
}
