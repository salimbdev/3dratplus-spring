package fr.eql.ai115.three.d.rat.plus.spring.controller.rest;


import fr.eql.ai115.three.d.rat.plus.spring.entity.Role;
import fr.eql.ai115.three.d.rat.plus.spring.entity.UserEntity;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.AuthResponseDto;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.LoginDto;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.RegisterDto;
import fr.eql.ai115.three.d.rat.plus.spring.jwt.JWTGenerator;
import fr.eql.ai115.three.d.rat.plus.spring.repository.RoleDao;
import fr.eql.ai115.three.d.rat.plus.spring.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("${front.url}")
public class SecurityController {

    private AuthenticationManager authenticationManager;
    private UserDao userRepository;
    private RoleDao roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public SecurityController(AuthenticationManager authenticationManager, UserDao userRepository, RoleDao roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator){
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }

        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setAddress(registerDto.getAddress());
        user.setCity(registerDto.getCity());
        user.setPostalCode(registerDto.getPostalCode());
        user.setPhoneNumber(registerDto.getPhoneNumber());

        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return  new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        AuthResponseDto authResponseDto = new AuthResponseDto(token);
        UserEntity user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        authResponseDto.setFirstName(user.getFirstName());
        authResponseDto.setLastName(user.getLastName());
        for (Role role : user.getRoles()) {
            authResponseDto.getRoles().add(role);
        }
        authResponseDto.setId(user.getId());
        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }
}
