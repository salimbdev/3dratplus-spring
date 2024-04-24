package fr.eql.ai115.three.d.rat.plus.spring.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String picture;
    @Column(nullable = false)
    private boolean available;
    @Column(nullable = false)
    private String brand;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Comment> comments;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;


    public Product() {
        this.comments = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public Product(String name, String description, double price, String picture, boolean available, String brand, List<Comment> comments, List<Category> categories) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.available = available;
        this.brand = brand;
        this.comments = comments;
        this.categories = categories;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
