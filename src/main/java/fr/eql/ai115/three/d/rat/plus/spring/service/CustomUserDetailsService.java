package fr.eql.ai115.three.d.rat.plus.spring.service;

import fr.eql.ai115.three.d.rat.plus.spring.entity.Role;
import fr.eql.ai115.three.d.rat.plus.spring.entity.UserEntity;
import fr.eql.ai115.three.d.rat.plus.spring.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UserDao userRepository;

    @Autowired
    public CustomUserDetailsService(UserDao userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }


    // conversion des roles en Granted Authorities
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
