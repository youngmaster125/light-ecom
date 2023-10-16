package org.sid.lightecom.controller;

import org.sid.lightecom.entities.Order1;
import org.sid.lightecom.entities.Payment;
import org.sid.lightecom.repository.OrderRepository;
import org.sid.lightecom.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    @RequestMapping(value = "/payment",method = RequestMethod.POST)
    public Payment pay(@RequestBody Payment pay){
        Order1 order=this.orderRepository.findById(pay.getOrder().getId()).get();

         pay.setDatePayment(LocalDateTime.now());
        Payment p=this.paymentRepository.save(pay);
        order.setPayment(p);
        order.setPaid(true);
        this.orderRepository.save(order);
        System.out.println("payment id :"+order.getPayment().getId());
        return p;
    }
}
