package com.github.hojoungjang.tekkencombomaker.dto;

import com.github.hojoungjang.tekkencombomaker.domain.Combo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateComboRequest {
    @NotNull
    private String name;

    @NotNull
    private String command;

    public Combo toEntity() {
        return Combo.builder()
                .name(name)
                .command(command)
                .build();
    }
}
