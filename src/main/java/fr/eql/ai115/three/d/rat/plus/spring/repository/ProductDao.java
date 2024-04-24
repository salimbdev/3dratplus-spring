package fr.eql.ai115.three.d.rat.plus.spring.repository;

import fr.eql.ai115.three.d.rat.plus.spring.entity.Category;
import fr.eql.ai115.three.d.rat.plus.spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    List<Product> findBy();

    Product findById(long idProduct);

    @Query("SELECT p FROM Product p INNER JOIN p.categories c WHERE c.id = :idCategory")
    List<Product> findByCategoryId(@Param("idCategory") long idCategory);

    @Query("SELECT c FROM Product p JOIN p.categories c WHERE p.id = :idProduct")
    List<Category> findProductCategory(@Param("idProduct") long idProduct);
}
