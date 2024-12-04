package net.ysf.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;
import net.ysf.model.Product;
@Entity
@Data
public class ProductItem {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String productId;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY )
	private Bill bill;
	private int quantity;
	private double unitPrice;
	@Transient
	private Product product;

}
