package com.github.hojoungjang.tekkencombomaker.service;

import com.github.hojoungjang.tekkencombomaker.config.error.exception.NotFoundException;
import com.github.hojoungjang.tekkencombomaker.domain.Combo;
import com.github.hojoungjang.tekkencombomaker.dto.CreateComboRequest;
import com.github.hojoungjang.tekkencombomaker.dto.UpdateComboRequest;
import com.github.hojoungjang.tekkencombomaker.repository.ComboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final 이나 @NotNull 이 붙은 필드의 생성자 추가
@Service
public class ComboService {
    private final ComboRepository comboRepo;

    public Combo getComboById(long id) {
        return comboRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<Combo> getAllCombo() {
        return comboRepo.findAll();
    }

    public Combo createCombo(CreateComboRequest request) {
        return comboRepo.save(request.toEntity());
    }

    public void deleteComboById(long id) {
        comboRepo.deleteById(id);
    }

    @Transactional
    public Combo updateCombo(long id, UpdateComboRequest request) {
        Combo combo = comboRepo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("not found: " + id)
        );
        combo.update(request.getName(), request.getCommand());
        return combo;
    }
}
