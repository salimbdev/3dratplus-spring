package fr.eql.ai115.three.d.rat.plus.spring.repository;

import fr.eql.ai115.three.d.rat.plus.spring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryDao extends JpaRepository<Category, Long> {
    List<Category> findBy();
    Optional<Category> findById(Long id);
}
