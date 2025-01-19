package com.github.hojoungjang.tekkencombomaker.dto;

import com.github.hojoungjang.tekkencombomaker.domain.Combo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateComboRequest {
    private String name;
    private String command;

    public Combo toEntity() {
        return Combo.builder()
                .name(name)
                .command(command)
                .build();
    }
}
