package com.codepathway.api.repository;

import com.codepathway.api.entity.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SheetRepository extends JpaRepository<Sheet, Long> {
    Optional<Sheet> findBySlug(String slug);
}
