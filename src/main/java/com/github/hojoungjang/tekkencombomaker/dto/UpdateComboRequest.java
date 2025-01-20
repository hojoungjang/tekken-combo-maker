package com.github.hojoungjang.tekkencombomaker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateComboRequest {
    private String name;
    private String command;
}
