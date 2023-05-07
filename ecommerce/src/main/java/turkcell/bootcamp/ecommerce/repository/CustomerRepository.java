package turkcell.bootcamp.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import turkcell.bootcamp.ecommerce.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
