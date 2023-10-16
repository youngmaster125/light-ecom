package org.sid.lightecom.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;


@Entity
public class Order1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm ss")
    private LocalDateTime date;
    @ManyToOne()
    private  Client client;
     @OneToMany(mappedBy = "order")
     private Collection<OrderItem> orderItems;

    private Double totalAmount;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Payment payment;
   private  Boolean paid;
    public Order1() {
    }

    public Order1(Long id, LocalDateTime date, Client client, Collection<OrderItem> orderItems, Double totalAmount,
                  Payment payment,Boolean paid) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.payment = payment;
        this.paid=paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Order1{" +
                "id=" + id +
                ", date=" + date +
                ", client=" + client +
                ", orderItems=" + orderItems +
                ", totalAmount=" + totalAmount +
                ", payment=" + payment +
                '}';
    }
}
