package org.sid.lightecom.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm ss")
    private LocalDateTime datePayment;
    private String typePayment;
    private Long cardNumber;
   @OneToOne(mappedBy = "payment")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order1 order;

    public Payment() {
    }

    public Payment(Long id, LocalDateTime datePayment, String typePayment, Long cardNumber, Order1 order) {
        this.id = id;
        this.datePayment = datePayment;
        this.cardNumber = cardNumber;
        this.order = order;
        this.typePayment=typePayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(LocalDateTime datePayment) {
        this.datePayment = datePayment;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Order1 getOrder() {
        return order;
    }

    public void setOrder(Order1 order) {
        this.order = order;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", datePayment=" + datePayment +
                ", typePayment='" + typePayment + '\'' +
                ", cardNumber=" + cardNumber +
                ", order=" + order +
                '}';
    }
}
