package fr.eql.ai115.three.d.rat.plus.spring.entity.dto;


import fr.eql.ai115.three.d.rat.plus.spring.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class AuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer ";
    private String firstName;
    private String lastName;
    private List<Role> roles;
    private Long id;

    public AuthResponseDto(String accessToken) {
        this.accessToken = accessToken;
        this.roles = new ArrayList<>();
    }

    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getTokenType() {
        return tokenType;
    }
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
