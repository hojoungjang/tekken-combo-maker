package com.github.hojoungjang.tekkencombomaker.dto;

import com.github.hojoungjang.tekkencombomaker.domain.Combo;
import lombok.Getter;

@Getter
public class ComboResponse {
    private final String name;
    private final String command;

    public ComboResponse(Combo combo) {
        this.name = combo.getName();
        this.command = combo.getCommand();
    }
}
