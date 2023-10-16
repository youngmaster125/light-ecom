package org.sid.lightecom.repository;


import org.sid.lightecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProductRepository  extends JpaRepository<Product,Long> {
    @RestResource(path = "seletectedproducts")
    public List<Product> findBySelectedIsTrue();

    @RestResource(path = "promoproducts")
    public List<Product> findByPromotionIsTrue();

    @RestResource(path = "dispoproducts")
    public List<Product> findByAvailableIsTrue();


    @RestResource(path = "seletectedfalse")
    public List<Product> findBySelectedIsFalse();

    @RestResource(path = "Name")
    public List<Product> findByNameContains(String mc);
    /**

    @RestResource(path = "p")
    @Query(value = "SELECT * FROM PRODUCT",nativeQuery = true)
    public List<Product> getpr();

*/
}
