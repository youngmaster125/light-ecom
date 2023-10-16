package org.sid.lightecom;


import org.sid.lightecom.config.RsakeysConfig;
import org.sid.lightecom.dao.ProductService;
import org.sid.lightecom.entities.*;
import org.sid.lightecom.repository.CategoryRepository;
import org.sid.lightecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Random;
import java.util.RandomAccess;

@SpringBootApplication
@EnableConfigurationProperties(RsakeysConfig.class)
public class LightEcomApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
@Autowired
	private  ProductService ps;



	public static void main(String[] args) {
		SpringApplication.run(LightEcomApplication.class, args);
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		  CorsConfiguration configuration = new CorsConfiguration();
		  configuration.setAllowedOrigins(Arrays.asList("*"));
		  configuration.setAllowedMethods(Arrays.asList("*"));
		  configuration.setAllowCredentials(true);
		  configuration.setAllowedHeaders(Arrays.asList("*"));
		 //  configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
		  UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		  source.registerCorsConfiguration("/**", configuration);
		  return source;

	}

	@Override
	public void run(String... args) throws Exception {
		this.restConfiguration.exposeIdsFor(Product.class, Category.class,
				Order1.class, Payment.class, OrderItem.class);
		this.categoryRepository.save(new Category("Ordinateur", "size 17", "unknown.png", null));
		this.categoryRepository.save(new Category("Imprimant", "color:pink", "unknown.png", null));
		this.categoryRepository.save(new Category("SmartPhone", "height:70", "unknown.png", null));
		

		this.categoryRepository.findAll().forEach(c -> {
			for (int i = 0; i < 4; i++) {
				Random rnd = new Random();
				String a="Product--"+i;
				Product p = new Product();
				p.setName(rnd.toString());
				p.setCurrentprice(100 + rnd.nextInt(1000));
				p.setAvailable(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setPhotoName("unknown.png");
				p.setCategory(c);

				this.productRepository.save(p);
			}


		});


	}
}
