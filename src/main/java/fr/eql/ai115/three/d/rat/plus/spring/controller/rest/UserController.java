package fr.eql.ai115.three.d.rat.plus.spring.controller.rest;

import fr.eql.ai115.three.d.rat.plus.spring.entity.*;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.CommentProductDto;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.QuoteRequestDto;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.UserDto;
import fr.eql.ai115.three.d.rat.plus.spring.repository.*;
import fr.eql.ai115.three.d.rat.plus.spring.service.UserEntityToUserDtoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    CommentDao commentDao;
    UserDao userDao;
    ProductDao productDao;
    CategoryDao categoryDao;
    QuoteRequestDao quoteRequestDao;

    UserEntityToUserDtoService userEntityToUserDtoService;

    @Autowired
    public UserController(CommentDao commentDao, UserDao userDao, ProductDao productDao, CategoryDao categoryDao, QuoteRequestDao quoteRequestDao, UserEntityToUserDtoService userEntityToUserDtoService) {
        this.commentDao = commentDao;
        this.userDao = userDao;
        this.productDao = productDao;
        this.categoryDao = categoryDao;
        this.quoteRequestDao = quoteRequestDao;
        this.userEntityToUserDtoService = userEntityToUserDtoService;
    }

    @PostMapping("/products/{id}/comment")
    public ResponseEntity<String> commentProduct(@RequestBody CommentProductDto commentProductDto, @PathVariable("id") Long idProduct) {
        // Comment the product
        UserEntity user = userDao.findById(commentProductDto.getIdUser()).orElseThrow(() -> new RuntimeException("User not found"));
        Comment comment = new Comment();
        Product product = productDao.findById(idProduct).orElseThrow(() -> new RuntimeException("Product not found"));

        comment.setContent(commentProductDto.getContent());
        comment.setRating(commentProductDto.getRating());
        comment.setUser(user);
        comment.setTitle(commentProductDto.getTitle());
        comment.setDateOfPublication(commentProductDto.getDateOfPublication());
        comment.setProduct(product);
        System.out.println(idProduct);
        commentDao.save(comment);

        return ResponseEntity.ok("Comment " + comment.getTitle() + " added successfully");
    }


    @PostMapping("/quote/request")
    public ResponseEntity<String> quoteRequest(@RequestBody QuoteRequestDto quoteRequestDto) {
        // Quote request
        UserEntity user = userDao.findById(quoteRequestDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Category category = categoryDao.findById(quoteRequestDto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));

        QuoteRequest quoteRequest = new QuoteRequest();
        quoteRequest.setCategory(category);
        quoteRequest.setUser(user);
        quoteRequest.setApproximatedPrice(quoteRequestDto.getApproximatedPrice());
        quoteRequest.setDescription(quoteRequestDto.getDescription());
        quoteRequest.setPicture1(quoteRequestDto.getPicture1());
        if (quoteRequestDto.getPicture2() != null) {
            quoteRequest.setPicture2(quoteRequestDto.getPicture2());
        }
        if (quoteRequestDto.getPicture3() != null) {
            quoteRequest.setPicture3(quoteRequestDto.getPicture3());
        }
        quoteRequest.setPieceNumber(quoteRequestDto.getPieceNumber());
        quoteRequest.setTotalArea(quoteRequestDto.getTotalArea());
        quoteRequest.setStartingDate(quoteRequestDto.getStartingDate());
        quoteRequest.setStartingDate(quoteRequestDto.getStartingDate());
        quoteRequest.setReceptionDate(quoteRequestDto.getReceptionDate());
        quoteRequest.setTreated(false);

        quoteRequestDao.save(quoteRequest);

        return ResponseEntity.ok("Quote request posted successfully");
    }

    @GetMapping("/quote/request/{idUser}")
    public ResponseEntity<List<QuoteRequestDto>> quoteRequestListByUser(@PathVariable("idUser") Long idUser) {
        // Quote request list by user
        UserEntity user = userDao.findById(idUser).orElseThrow(() -> new RuntimeException("User not found"));
        UserDto userDto = userEntityToUserDtoService.convertUserEntityToUserDto(user);
        List<QuoteRequest> quoteRequests = quoteRequestDao.findByUser(user);
        List<QuoteRequestDto> quoteRequestDtos = new ArrayList<>();
        for (QuoteRequest quoteRequest : quoteRequests) {
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
            quoteRequestDto.setUser(userDto);
            quoteRequestDtos.add(quoteRequestDto);
        }
        return ResponseEntity.ok(quoteRequestDtos);
    }

    @GetMapping("/quote/request/{idUser}/{idQuoteRequest}")
    public ResponseEntity<QuoteRequestDto> quoteRequestSingle(@PathVariable("idUser") Long idUser, @PathVariable("idQuoteRequest") Long idQuoteRequest){
        // Quote request list by user
        UserEntity user = userDao.findById(idUser).orElseThrow(() -> new RuntimeException("User not found"));
        UserDto userDto = userEntityToUserDtoService.convertUserEntityToUserDto(user);
        QuoteRequest quoteRequest = quoteRequestDao.findByIdAndUser(idQuoteRequest ,user).orElseThrow(() -> new RuntimeException("Quote request not found"));
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
        quoteRequestDto.setUser(userDto);
        return ResponseEntity.ok(quoteRequestDto);
    }

    @PostMapping("/update/information/user/{idUser}")
    public ResponseEntity<String> updateInformationUser(@RequestBody UserDto userDto, @PathVariable("idUser") Long idUser) {
        // Update information user
        UserEntity user = userDao.findById(idUser).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setPostalCode(userDto.getPostalCode());
        user.setPhoneNumber(userDto.getPhoneNumber());
        userDao.save(user);
        return ResponseEntity.ok("User information updated successfully");
    }

    @GetMapping("/get/information/user/{idUser}")
    public ResponseEntity<UserDto> getInformationUser(@PathVariable("idUser") Long idUser) {
        // Get information user
        UserEntity user = userDao.findById(idUser).orElseThrow(() -> new RuntimeException("User not found"));
        UserDto userDto = userEntityToUserDtoService.convertUserEntityToUserDto(user);
        return ResponseEntity.ok(userDto);
    }
}
