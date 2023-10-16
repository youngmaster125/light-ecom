package org.sid.lightecom.controller;


import org.sid.lightecom.dao.ProductService;
import org.sid.lightecom.entities.Category;
import org.sid.lightecom.entities.Product;
import org.sid.lightecom.repository.CategoryRepository;
import org.sid.lightecom.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@CrossOrigin("*")
public class CatalogueRestController {

    //@Autowired
    private ProductRepository productRepository;
   // @Autowired
    private CategoryRepository categoryRepository;
    //@Autowired
    private ProductService ps;

    public CatalogueRestController(ProductRepository productRepository, CategoryRepository categoryRepository, ProductService ps) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.ps = ps;
    }

    @GetMapping(path = "/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
        public byte[] getPhoto(@PathVariable Long id) throws  Exception{

            Product p=productRepository.findById(id).orElse(new Product());

          return  Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()));



    }
@PostMapping("/uploadPhoto/{id}")
   public void uploadPhoto(MultipartFile file,@PathVariable Long id) throws  Exception {
            System.out.println(file.getOriginalFilename());
            Product p=this.productRepository.findById(id).orElse(new Product());
            p.setPhotoName(id+".jpg");
            Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"
                   +p.getPhotoName()),file.getBytes());
             this.productRepository.save(p);


   }
    @RequestMapping(value="/updateProduct/{id}",method=RequestMethod.PUT)
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
   public Product updateProduct(@PathVariable Long id, @RequestBody Product p){

       Product p1=this.productRepository.findById(id).orElse(new Product());
         p1.setName(p.getName());
         p1.setDescription(p.getDescription());
         p1.setCurrentprice(p.getCurrentprice());
         p1.setSelected(p.getSelected());
         p1.setPromotion(p1.getPromotion());
         p1.setAvailable(p.getAvailable());
        return this.ps.updateProduct(p1);


   }

    @PostMapping("/addProduct/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Product addProduct(@RequestBody Product p,@PathVariable Long id) throws  Exception {
            Category category=this.categoryRepository.findById(id).get();
            p.setCategory(category);
            p.setPhotoName("unknown.png");
            return this.productRepository.save(p);

    }

}
