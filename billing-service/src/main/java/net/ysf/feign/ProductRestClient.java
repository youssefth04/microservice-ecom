package net.ysf.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.ysf.model.Product;
@FeignClient("inventory-service")
public interface ProductRestClient {
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable String id);
	
	@GetMapping("/products")
	public PagedModel<Product> getAllProductB();

}
