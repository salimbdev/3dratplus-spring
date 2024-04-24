package fr.eql.ai115.three.d.rat.plus.spring.entity.dto;

import java.time.LocalDate;

public class CommentDisplayDto {
    private String content;
    private LocalDate dateOfPublication;
    private double rating;
    private String title;
    private String firstName;
    private String lastName;

    public CommentDisplayDto() {
    }

    public CommentDisplayDto(String content, LocalDate dateOfPublication, double rating, String title, String firstName, String lastName) {
        this.content = content;
        this.dateOfPublication = dateOfPublication;
        this.rating = rating;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
