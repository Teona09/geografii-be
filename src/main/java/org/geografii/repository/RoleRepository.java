package org.geografii.repository;

import org.geografii.dto.RoleModelDTO;
import org.geografii.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findByNameIgnoreCaseIn(Set<RoleModelDTO> roleModels);

    Optional<RoleModel> findByNameIgnoreCase(String roleModel);
}
