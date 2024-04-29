package fr.eql.ai115.three.d.rat.plus.spring.controller.rest;

import fr.eql.ai115.three.d.rat.plus.spring.entity.*;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.CommentDisplayDto;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.ProductDisplayDto;
import fr.eql.ai115.three.d.rat.plus.spring.repository.*;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin("${front.url}")
public class PublicController {

    private ProductDao productDao;
    private ServicePropositionDao servicePropositionDao;
    private CategoryDao categoryDao;
    private CommentDao commentDao;
    private UserDao userDao;

    @Autowired
    public PublicController(ProductDao productDao, ServicePropositionDao servicePropositionDao, CategoryDao categoryDao, CommentDao commentDao, UserDao userDao) {
        this.productDao = productDao;
        this.servicePropositionDao = servicePropositionDao;
        this.categoryDao = categoryDao;
        this.commentDao = commentDao;
        this.userDao = userDao;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productDao.findBy();
    }

    @GetMapping("/product/{id}")
    public ProductDisplayDto getProductById(@PathVariable("id") Long id) {
        Product product = productDao.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        List<Comment> comments = commentDao.findByProductId(id);
        List<Category> categories = productDao.findProductCategory(id);

        ProductDisplayDto productDisplayDto = new ProductDisplayDto();
        productDisplayDto.setId(product.getId());
        productDisplayDto.setName(product.getName());
        productDisplayDto.setDescription(product.getDescription());
        productDisplayDto.setPrice(product.getPrice());
        productDisplayDto.setPicture(product.getPicture());
        productDisplayDto.setAvailable(product.isAvailable());
        productDisplayDto.setBrand(product.getBrand());
        List<CommentDisplayDto> commentsToDisplay = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDisplayDto commentDisplayDto = new CommentDisplayDto();
            commentDisplayDto.setContent(comment.getContent());
            commentDisplayDto.setRating(comment.getRating());
            commentDisplayDto.setTitle(comment.getTitle());
            commentDisplayDto.setDateOfPublication(comment.getDateOfPublication());
            UserEntity user = userDao.findById(comment.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
            commentDisplayDto.setFirstName(user.getFirstName());
            commentDisplayDto.setLastName(user.getLastName());
            commentsToDisplay.add(commentDisplayDto);
        }
        productDisplayDto.getCategories().addAll(categories);

        System.out.println(commentsToDisplay.size());
        productDisplayDto.getComments().addAll(commentsToDisplay);
        return productDisplayDto;
    }

    @GetMapping("/services")
    public List<ServiceProposition> getServices() {
        return servicePropositionDao.findBy();
    }

    @GetMapping("/service/{id}")
    public ServiceProposition getServiceById(@PathVariable("id") Long id) {
        return servicePropositionDao.findById(id).orElseThrow();
    }

    @GetMapping("/categories")
    public List<Category> getCategory(){
        return categoryDao.findBy();
    }
}
