package org.sid.lightecom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private String description;
    private double currentprice;
    private Boolean promotion;
    private  Boolean selected;
    private Boolean available;
    private  String photoName;
    @JsonIgnore
    @ManyToOne
    private  Category  category;
@Transient
  private transient int quantity=1;
    public Product() {
    }

    public Product(Long id, String name, String description, double currentprice, Boolean promotion, Boolean selected, Boolean available, String photoName, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.currentprice = currentprice;
        this.promotion = promotion;
        this.selected = selected;
        this.available = available;
        this.photoName = photoName;
        this.category = category;
    }

    public Product(String name, String description, double currentprice, Boolean promotion, Boolean selected, Boolean available, String photoName, Category category) {
        this.name = name;
        this.description = description;
        this.currentprice = currentprice;
        this.promotion = promotion;
        this.selected = selected;
        this.available = available;
        this.photoName = photoName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCurrentprice() {
        return currentprice;
    }

    public void setCurrentprice(double currentprice) {
        this.currentprice = currentprice;
    }

    public Boolean getPromotion() {
        return promotion;
    }

    public void setPromotion(Boolean promotion) {
        this.promotion = promotion;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", currentprice=" + "currentprice" +
                ", promotion=" + promotion +
                ", selected=" + selected +
                ", available=" + available +
                ", photoName='" + photoName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
