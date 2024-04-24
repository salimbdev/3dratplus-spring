package fr.eql.ai115.three.d.rat.plus.spring.entity.dto;

import fr.eql.ai115.three.d.rat.plus.spring.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class ProductDisplayDto {

    private Long id;
    private String name;
    private String description;
    private double price;
    private String picture;
    private boolean available;
    private String brand;
    private List<CommentDisplayDto> comments;
    private List<Category> categories;


    public ProductDisplayDto() {
        this.comments = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<CommentDisplayDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDisplayDto> comments) {
        this.comments = comments;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
