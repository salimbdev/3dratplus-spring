package fr.eql.ai115.three.d.rat.plus.spring.repository;

import fr.eql.ai115.three.d.rat.plus.spring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity, Long>{
    UserEntity findById(long idUser);
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);

}
