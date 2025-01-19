package com.github.hojoungjang.tekkencombomaker.repository;

import com.github.hojoungjang.tekkencombomaker.domain.Combo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComboRepository extends JpaRepository<Combo, Long> {
}
