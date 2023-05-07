package turkcell.bootcamp.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import turkcell.bootcamp.ecommerce.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
