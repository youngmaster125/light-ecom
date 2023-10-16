package org.sid.lightecom.controller;

import org.sid.lightecom.entities.*;
import org.sid.lightecom.repository.ClientRepository;
import org.sid.lightecom.repository.OrderItemRepository;
import org.sid.lightecom.repository.OrderRepository;
import org.sid.lightecom.repository.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.Date;

@RestController
@CrossOrigin("*")
public class OrderController {

    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    private OrderItemRepository orderItemRepository;


    public OrderController(ProductRepository productRepository, OrderRepository orderRepository, ClientRepository clientRepository, OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.orderItemRepository = orderItemRepository;
    }
    @PostMapping("/orders")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Order1 SaveOrder(@RequestBody OrderForm orderForm){
    Client client=new Client();
    client.setName(orderForm.getClient().getName());
    client.setEmail(orderForm.getClient().getEmail());
    client.setAdresse(orderForm.getClient().getAdresse());
    client.setPhoneNumber(orderForm.getClient().getPhoneNumber());
    client.setUsername(orderForm.getClient().getUsername());
    this.clientRepository.save(client);
    System.out.println(client.getId());

    Order1 order=new Order1();
    order.setClient(client);
    order.setDate(LocalDateTime.now());
   double total=0;
    order=this.orderRepository.save(order);
    for(OrderProduct p: orderForm.getProducts()){
        OrderItem orderItem=new OrderItem();
        orderItem.setOrder(order);
        Product product=this.productRepository.findById(p.getId()).get();
        orderItem.setProduct(product);
        orderItem.setPrice(product.getCurrentprice());
        orderItem.setQuantity(p.getQuantity());
        this.orderItemRepository.save(orderItem);
        total+=p.getQuantity()*product.getCurrentprice();

    }
    order.setPaid(false);
   order.setTotalAmount(total);

    return  this.orderRepository.save(order);
    }
}
