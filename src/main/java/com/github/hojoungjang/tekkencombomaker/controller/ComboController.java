package com.github.hojoungjang.tekkencombomaker.controller;

import com.github.hojoungjang.tekkencombomaker.domain.Combo;
import com.github.hojoungjang.tekkencombomaker.dto.ComboResponse;
import com.github.hojoungjang.tekkencombomaker.dto.CreateComboRequest;
import com.github.hojoungjang.tekkencombomaker.dto.UpdateComboRequest;
import com.github.hojoungjang.tekkencombomaker.service.ComboService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/combos")
public class ComboController {
    private final ComboService comboService;

    @GetMapping("/{id}")
    public ResponseEntity<ComboResponse> getComboById(@PathVariable("id") long id) {
        Combo combo = comboService.getComboById(id);
        return ResponseEntity.ok()
                .body(new ComboResponse(combo));
    }

    @GetMapping
    public ResponseEntity<List<ComboResponse>> getAllCombo() {
        List<ComboResponse> combos = comboService.getAllCombo()
                .stream()
                .map(ComboResponse::new)
                .toList();
        return ResponseEntity.ok().body(combos);
    }

    @PostMapping
    public ResponseEntity<Combo> createCombo(@RequestBody @Validated CreateComboRequest request) {
        Combo combo = comboService.createCombo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(combo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCombo(@PathVariable long id) {
        comboService.deleteComboById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComboResponse> updateCombo(@PathVariable long id, @RequestBody UpdateComboRequest request) {
        Combo combo = comboService.updateCombo(id, request);
        return ResponseEntity.ok().body(new ComboResponse(combo));
    }
}
