package org.sid.lightecom.repository;

import org.sid.lightecom.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface OrderRepository extends JpaRepository<Order1,Long> {
    @RestResource(path = "username")
    public List<Order1> findByClientUsername(String mc);

    @RestResource(path = "detailorder")
    @Query("SELECT p FROM Order1 p")
     public List<Order1> detailsOrder(String mc);

}
