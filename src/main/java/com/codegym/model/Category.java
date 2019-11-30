package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long category_Id;
    private String category_name;
    private String category_description;

    @OneToMany(targetEntity = Phone.class)
    private List<Phone> phones;
    public Category() {
    }

    public Category(Long category_Id, String category_name, String category_description) {
        this.category_Id = category_Id;
        this.category_name = category_name;
        this.category_description = category_description;
    }

    public Long getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(Long category_Id) {
        this.category_Id = category_Id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }
}