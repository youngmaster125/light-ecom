package org.sid.lightecom.repository;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.sid.lightecom.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;



public interface OrderItemRepository1 extends JpaRepository<OrderItem,Long> {

   //@Query(value = "SELECT * FROM order_items",nativeQuery = true)
  // public List<OrderItem> detailsOrder();

}
// (Long id, String name, double price, int quantity)
//SELECT new org.sid.lightecom.dto.OrderResponse(p.name,c.price,c.quantity) FROM OrderItem c JOIN c.product p'
//SELECT new org.sid.lightecom.dto.OrderResponse(p.name,c.qte,c.price) FROM OrderItem c JOIN c.product p