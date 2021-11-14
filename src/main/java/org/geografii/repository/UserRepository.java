package org.geografii.repository;

import org.geografii.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
        Optional<UserModel> findByEmail(String email);

        boolean existsByEmailIgnoreCase(String email);

        Optional<UserModel> findById(Long id);
}
