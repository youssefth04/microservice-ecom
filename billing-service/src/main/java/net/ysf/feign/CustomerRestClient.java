package net.ysf.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.ysf.model.Customer;
@FeignClient("customer-service")
public interface CustomerRestClient {
	@GetMapping("/customers/{id}")
	public Customer findCustomerById(@PathVariable Long id);
	
	@GetMapping("/customers")
	public PagedModel<Customer> getAllCustomers();

}
