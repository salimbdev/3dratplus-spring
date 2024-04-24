package fr.eql.ai115.three.d.rat.plus.spring.repository;

import fr.eql.ai115.three.d.rat.plus.spring.entity.QuoteRequest;
import fr.eql.ai115.three.d.rat.plus.spring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuoteRequestDao extends JpaRepository<QuoteRequest, Long> {
    List<QuoteRequest> findByUser(UserEntity userEntity);
    Optional<QuoteRequest> findByIdAndUser(Long id, UserEntity userEntity);
    List<QuoteRequest> findBy();
}
