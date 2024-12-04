package net.ysf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.ysf.entities.Bill;
@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {

}
