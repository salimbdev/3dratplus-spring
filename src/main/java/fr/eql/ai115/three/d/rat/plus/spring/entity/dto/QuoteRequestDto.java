package fr.eql.ai115.three.d.rat.plus.spring.entity.dto;

import fr.eql.ai115.three.d.rat.plus.spring.entity.Category;
import fr.eql.ai115.three.d.rat.plus.spring.entity.UserEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

public class QuoteRequestDto {


    private LocalDate receptionDate;
    private LocalDate startingDate;
    private String description;
    private int pieceNumber;
    private double totalArea;
    private String picture1;
    private String picture2;
    private String picture3;
    private double approximatedPrice;
    private Long categoryId;
    private Long userId;
    private Category category;
    private UserDto user;
    private Boolean isTreated;


    public QuoteRequestDto() {
    }

    public LocalDate getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(LocalDate receptionDate) {
        this.receptionDate = receptionDate;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPieceNumber() {
        return pieceNumber;
    }

    public void setPieceNumber(int pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public String getPicture1() {
        return picture1;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }

    public double getApproximatedPrice() {
        return approximatedPrice;
    }

    public void setApproximatedPrice(double approximatedPrice) {
        this.approximatedPrice = approximatedPrice;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Boolean isTreated() {
        return isTreated;
    }

    public void setIsTreated(Boolean isTreated) {
        this.isTreated = isTreated;
    }

}
