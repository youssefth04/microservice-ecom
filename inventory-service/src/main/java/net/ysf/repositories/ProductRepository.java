package net.ysf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.ysf.entities.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String>{

}
