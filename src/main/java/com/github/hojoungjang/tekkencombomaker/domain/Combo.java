package com.github.hojoungjang.tekkencombomaker.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Combo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "command", nullable = false)
    private String command;

    @Builder
    public Combo(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public void update(String name, String command) {
        this.name = name;
        this.command = command;
    }
}
