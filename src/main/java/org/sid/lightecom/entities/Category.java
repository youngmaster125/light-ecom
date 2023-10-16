package org.sid.lightecom.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
@Entity
public class Category implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private String description;
   private String  photo;
    @OneToMany(mappedBy ="category",cascade = CascadeType.ALL)
    private Collection<Product> products;

    public Category() {
    }

    public Category(Long id, String name, String description, String photo, Collection<Product> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.products = products;
    }

    public Category(String name, String description, String photo, Collection<Product> products) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.products = products;
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

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", products=" + products +
                '}';
    }

}
