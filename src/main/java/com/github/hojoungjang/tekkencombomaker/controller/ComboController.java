package com.github.hojoungjang.tekkencombomaker.controller;

import com.github.hojoungjang.tekkencombomaker.domain.Combo;
import com.github.hojoungjang.tekkencombomaker.dto.CreateComboRequest;
import com.github.hojoungjang.tekkencombomaker.service.ComboService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ComboController {
    private final ComboService comboService;

    @PostMapping("/api/v1/combo")
    public ResponseEntity<Combo> createCombo(@RequestBody CreateComboRequest request) {
        Combo combo = comboService.createCombo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(combo);
    }
}
