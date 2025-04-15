package com.teste.wayonTiago.controller;

import com.teste.wayonTiago.Dto.TesteRecord;
import com.teste.wayonTiago.service.TesteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teste")
public class TesteController {
    final TesteService testeService;

    public TesteController(TesteService testeService) {
        this.testeService = testeService;
    }

    @PostMapping
    public ResponseEntity<List<String>> getResult(@RequestBody TesteRecord testeRecord) {
        return ResponseEntity.status(HttpStatus.OK).body(testeService.getAnagrama(testeRecord));
    }
}
