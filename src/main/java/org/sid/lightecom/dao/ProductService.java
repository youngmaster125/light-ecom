package org.sid.lightecom.dao;

import org.sid.lightecom.entities.Product;
import org.sid.lightecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class ProductService {
    @Autowired
   private ProductRepository p;


    public Product updateProduct(Product p){
     return this.p.save(p);
    }



}
