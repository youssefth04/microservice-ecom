package net.ysf;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.ysf.entities.Product;
import net.ysf.repositories.ProductRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args->{
		Stream.of("xxxx","sssss","sssss").forEach(p->{
			Product product= new Product();
			product.setId(UUID.randomUUID().toString());
			product.setName(p);
			product.setPrice(Math.random()*1000);
			product.setQuantity((int)Math.random()*100+100);
			productRepository.save(product);
		});
		productRepository.findAll().forEach(p->{
			System.out.println("xxxxxxxxxxxxxxxxx");
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getPrice());
			System.out.println(p.getQuantity());
			System.out.println("xxxxxxxxxxxxxxxxxxxxx");
		});
		
		};	
	}

}
