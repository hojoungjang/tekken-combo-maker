package com.github.hojoungjang.tekkencombomaker.config.error;


import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "E1", "올바르지 않은 입력값입니다.");

    private final String message;
    private final String code;
    private final HttpStatus status;

    ErrorCode(final HttpStatus status, final String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
