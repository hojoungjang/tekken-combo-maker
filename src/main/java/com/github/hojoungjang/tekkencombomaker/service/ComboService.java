package com.github.hojoungjang.tekkencombomaker.service;

import com.github.hojoungjang.tekkencombomaker.domain.Combo;
import com.github.hojoungjang.tekkencombomaker.dto.CreateComboRequest;
import com.github.hojoungjang.tekkencombomaker.repository.ComboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final 이나 @NotNull 이 붙은 필드의 생성자 추가
@Service
public class ComboService {
    private final ComboRepository comboRepo;

    public Combo createCombo(CreateComboRequest request) {
        return comboRepo.save(request.toEntity());
    }
}
