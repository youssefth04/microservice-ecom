package net.ysf.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;
import net.ysf.model.Customer;
@Entity
@Data
public class Bill {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date billingDate;
	private Long customerId;
	@OneToMany(mappedBy = "bill")
	private List<ProductItem> productItem=new ArrayList<>() ;
	
   @Transient private Customer customer;

}
