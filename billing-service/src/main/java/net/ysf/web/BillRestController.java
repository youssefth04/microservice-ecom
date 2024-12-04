package net.ysf.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.ysf.entities.Bill;
import net.ysf.feign.CustomerRestClient;
import net.ysf.feign.ProductRestClient;
import net.ysf.repositories.BillRepository;
import net.ysf.repositories.ProductItemRepository;

@RestController
@RequiredArgsConstructor
public class BillRestController {
	
	private final CustomerRestClient customerRestClient;
	private final ProductItemRepository productItemRepository;
	private final ProductRestClient productRestClient;
	private final BillRepository billRepository;
	
	@GetMapping("/bills/{id}")
	public Bill getBill(@PathVariable Long id) {
		Bill bill=billRepository.findById(id).orElse(null);
		bill.setCustomer( customerRestClient.findCustomerById(bill.getCustomerId()));
		bill.getProductItem().forEach(pro->{
			pro.setProduct(productRestClient.getProductById(pro.getProductId()));
			
			
		});
		return bill;
	}

}
