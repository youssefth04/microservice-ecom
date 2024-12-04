package net.ysf;

import java.util.Collection;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import net.ysf.entities.Bill;
import net.ysf.entities.ProductItem;
import net.ysf.feign.CustomerRestClient;
import net.ysf.feign.ProductRestClient;
import net.ysf.model.Customer;
import net.ysf.model.Product;
import net.ysf.repositories.BillRepository;
import net.ysf.repositories.ProductItemRepository;
@EnableFeignClients
@SpringBootApplication
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository , ProductItemRepository productItemRepository,
			CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
		return args->{
			
			Collection<Customer> customers=customerRestClient.getAllCustomers().getContent();
			Collection<Product> products = productRestClient.getAllProductB().getContent();
			
			customers.forEach(c->{
				Bill bill= new Bill();
				bill.setCustomerId(c.getId());
				bill.setBillingDate(new Date());
				billRepository.save(bill);
				
				products.forEach(p->{
					ProductItem productItem=new ProductItem();
					productItem.setProductId(p.getId());
					productItem.setQuantity(10);
					productItem.setUnitPrice(p.getPrice());
					productItem.setBill(bill);
					productItemRepository.save(productItem);
					
					
					
				});
			});
			
		};
	}

}
