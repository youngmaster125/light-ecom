package org.sid.lightecom.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class OrderItem implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
   private Product product;
    private  int  quantity;
    private Double price;
      @ManyToOne
     @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
      private Order1 order;


    public OrderItem() {
    }

    public OrderItem(Long id, Product product, int quantity, Double price, Order1 order) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }
  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order1 getOrder() {
        return order;
    }

    public void setOrder(Order1 order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", order=" + order +
                '}';
    }
}
