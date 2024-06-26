package fr.eql.ai115.three.d.rat.plus.spring.repository;

import fr.eql.ai115.three.d.rat.plus.spring.entity.ServiceProposition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServicePropositionDao extends JpaRepository<ServiceProposition, Long> {
    List<ServiceProposition> findBy();
    Optional<ServiceProposition> findById(long id);
}
