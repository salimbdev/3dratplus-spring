package fr.eql.ai115.three.d.rat.plus.spring.repository;

import fr.eql.ai115.three.d.rat.plus.spring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);

}
