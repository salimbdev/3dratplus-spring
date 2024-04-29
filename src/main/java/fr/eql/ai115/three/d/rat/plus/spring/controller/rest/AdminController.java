package fr.eql.ai115.three.d.rat.plus.spring.controller.rest;

import fr.eql.ai115.three.d.rat.plus.spring.entity.Category;
import fr.eql.ai115.three.d.rat.plus.spring.entity.Product;
import fr.eql.ai115.three.d.rat.plus.spring.entity.QuoteRequest;
import fr.eql.ai115.three.d.rat.plus.spring.entity.UserEntity;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.ProductRegisterDto;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.QuoteRequestDto;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.UserDto;
import fr.eql.ai115.three.d.rat.plus.spring.repository.CategoryDao;
import fr.eql.ai115.three.d.rat.plus.spring.repository.ProductDao;
import fr.eql.ai115.three.d.rat.plus.spring.repository.QuoteRequestDao;
import fr.eql.ai115.three.d.rat.plus.spring.repository.UserDao;
import fr.eql.ai115.three.d.rat.plus.spring.service.UserEntityToUserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("${front.url}")
public class AdminController {

    private ProductDao productDao;
    private CategoryDao categoryDao;
    private QuoteRequestDao quoteRequestDao;
    private UserEntityToUserDtoService userEntityToUserDtoService;
    private UserDao userDao;

    @Autowired
    public AdminController(ProductDao productDao, CategoryDao categoryDao, QuoteRequestDao quoteRequestDao, UserDao userDao, UserEntityToUserDtoService userEntityToUserDtoService) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
        this.quoteRequestDao = quoteRequestDao;
        this.userDao = userDao;
        this.userEntityToUserDtoService = userEntityToUserDtoService;
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody ProductRegisterDto productDto) {
        Product product = new Product();
        List<Category> categories = new ArrayList<>();
        for (Long categoryId : productDto.getCategoriesId()) {
            Category category = categoryDao.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
            categories.add(category);
        }
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setPicture(productDto.getPicture());
        product.setAvailable(productDto.isAvailable());
        product.setBrand(productDto.getBrand());
        product.getCategories().addAll(categories);
        productDao.save(product);
        return ResponseEntity.ok("{'message': 'Product " + product.getName() + " added'}");
    }

    @PostMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductRegisterDto productDto, @PathVariable("id") Long id) {
        Product product = productDao.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        List<Category> categories = new ArrayList<>();
        for (Long categoryId : productDto.getCategoriesId()) {
            Category category = categoryDao.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
            categories.add(category);
        }
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setPicture(productDto.getPicture());
        product.setAvailable(productDto.isAvailable());
        product.setBrand(productDto.getBrand());
        product.getCategories().addAll(categories);
        productDao.save(product);
        return ResponseEntity.ok("{'message': 'Product " + product.getName() + " updated'}");
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        Product product = productDao.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productDao.delete(product);
        return ResponseEntity.ok("{'message': 'Product " + product.getName() + " deleted'}");
    }


    @PostMapping("/quote/request/{id}")
    public ResponseEntity<String> treatQuoteRequest(@PathVariable("id") Long id) {
        // Treat the quote request
        QuoteRequest quoteRequest = quoteRequestDao.findById(id).orElseThrow(() -> new RuntimeException("Quote request not found"));
        quoteRequest.setTreated(true);
        quoteRequestDao.save(quoteRequest);
        return ResponseEntity.ok("Quote request " + quoteRequest.getId() + " treated");
    }

    @GetMapping("/quote/request")
    public ResponseEntity<List<QuoteRequestDto>> quoteRequestList() {
        // Quote request list by user

        List<QuoteRequest> quoteRequests = quoteRequestDao.findBy();
        List<QuoteRequestDto> quoteRequestDtos = new ArrayList<>();
        for (QuoteRequest quoteRequest : quoteRequests) {
            UserEntity user = userDao.findById(quoteRequest.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
            UserDto userDto = userEntityToUserDtoService.convertUserEntityToUserDto(user);
            QuoteRequestDto quoteRequestDto = new QuoteRequestDto();
            quoteRequestDto.setCategory(quoteRequest.getCategory());
            quoteRequestDto.setApproximatedPrice(quoteRequest.getApproximatedPrice());
            quoteRequestDto.setDescription(quoteRequest.getDescription());
            quoteRequestDto.setPicture1(quoteRequest.getPicture1());
            quoteRequestDto.setPicture2(quoteRequest.getPicture2());
            quoteRequestDto.setPicture3(quoteRequest.getPicture3());
            quoteRequestDto.setPieceNumber(quoteRequest.getPieceNumber());
            quoteRequestDto.setTotalArea(quoteRequest.getTotalArea());
            quoteRequestDto.setStartingDate(quoteRequest.getStartingDate());
            quoteRequestDto.setReceptionDate(quoteRequest.getReceptionDate());
            quoteRequestDto.setIsTreated(quoteRequest.isTreated());
            quoteRequestDto.setUser(userDto);
            quoteRequestDtos.add(quoteRequestDto);
        }
        return ResponseEntity.ok(quoteRequestDtos);
    }
}
