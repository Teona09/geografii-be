package org.geografii.repository;

import org.geografii.model.LevelModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelRepository extends JpaRepository<LevelModel, Long> {
    Optional<LevelModel> findByRegion(String regiune);
}
