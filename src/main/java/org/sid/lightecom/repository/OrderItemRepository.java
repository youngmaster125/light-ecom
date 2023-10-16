package org.sid.lightecom.repository;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.sid.lightecom.dto.OrderResponse;
import org.sid.lightecom.entities.Order1;
import org.sid.lightecom.entities.OrderDetails;
import org.sid.lightecom.entities.OrderItem;
import org.sid.lightecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

    @RestResource(path = "detailorderItem")
    @Query("SELECT o from OrderItem o JOIN FETCH o.product p ")
    public List<OrderItem> detailsOrder(String mc);

    String sql = "SELECT * FROM orderitem ";

}
// (Long id, String name, double price, int quantity)
//SELECT new org.sid.lightecom.dto.OrderResponse(p.name,c.price,c.quantity) FROM OrderItem c JOIN c.product p'
//SELECT new org.sid.lightecom.dto.OrderResponse(p.name,c.qte,c.price) FROM OrderItem c JOIN c.product p