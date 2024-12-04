package net.ysf.gestiondestock;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.ysf.gestiondestock.entities.Customer;
import net.ysf.gestiondestock.repositories.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args->{
			
			Stream.of("gggggggg","fffffff","dddddddd").forEach(c->{
				Customer customer=new Customer();
				customer.setName(c);
				customer.setEmail(c+"gmail.com");
				customerRepository.save(customer);
			});			
			
			customerRepository.findAll().forEach(c->{
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println(c.getId());
				System.out.println(c.getEmail());
				System.out.println(c.getName());
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			});
		};
	}

}
