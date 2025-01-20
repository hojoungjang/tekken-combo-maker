package com.github.hojoungjang.tekkencombomaker.controller;

import com.github.hojoungjang.tekkencombomaker.domain.Combo;
import com.github.hojoungjang.tekkencombomaker.dto.ComboResponse;
import com.github.hojoungjang.tekkencombomaker.dto.CreateComboRequest;
import com.github.hojoungjang.tekkencombomaker.service.ComboService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/combo")
public class ComboController {
    private final ComboService comboService;

    @GetMapping("/{id}")
    public ResponseEntity<ComboResponse> getComboById(@PathVariable long id) {
        Combo combo = comboService.getComboById(id);
        return ResponseEntity.ok()
                .body(new ComboResponse(combo));
    }

    @PostMapping
    public ResponseEntity<Combo> createCombo(@RequestBody CreateComboRequest request) {
        Combo combo = comboService.createCombo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(combo);
    }


}
