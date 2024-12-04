package net.ysf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.ysf.entities.ProductItem;
@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long>{

}
