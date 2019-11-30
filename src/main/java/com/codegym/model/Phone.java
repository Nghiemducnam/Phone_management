package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "Phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate dateOfPurchase;
    private Double price;
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn(name = "Category_id")
    private Category category;
    public Phone() {
    }

    public Phone(String name, LocalDate dateOfPurchase, Double price, String description, String image, Category category) {
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
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

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}