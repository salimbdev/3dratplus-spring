package fr.eql.ai115.three.d.rat.plus.spring.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class QuoteRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate receptionDate;
    @Column(nullable = false)
    private LocalDate startingDate;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int pieceNumber;
    @Column(nullable = false)
    private double totalArea;
    @Column(nullable = false)
    private String picture1;
    @Column(nullable = true)
    private String picture2;
    @Column(nullable = true)
    private String picture3;
    private double approximatedPrice;
    @OneToOne(fetch = FetchType.EAGER)
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private UserEntity user;

    @Column(nullable = false)
    private Boolean isTreated;

    public QuoteRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public boolean isTreated() {
        return isTreated;
    }

    public void setTreated(boolean isTreated) {
        this.isTreated = isTreated;
    }


    @Override
    public String toString() {
        return "QuoteRequest{" +
                "id=" + id +
                ", receptionDate=" + receptionDate +
                ", startingDate=" + startingDate +
                ", description='" + description + '\'' +
                ", pieceNumber=" + pieceNumber +
                ", totalArea=" + totalArea +
                ", picture1='" + picture1 + '\'' +
                ", picture2='" + picture2 + '\'' +
                ", picture3='" + picture3 + '\'' +
                ", approximatedPrice=" + approximatedPrice +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}
