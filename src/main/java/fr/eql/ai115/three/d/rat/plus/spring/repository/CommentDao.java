package fr.eql.ai115.three.d.rat.plus.spring.repository;

import fr.eql.ai115.three.d.rat.plus.spring.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c INNER JOIN c.product p INNER JOIN c.user u WHERE p.id = :idProduct")
    List<Comment> findByProductId(@Param("idProduct") long idProduct);


}
