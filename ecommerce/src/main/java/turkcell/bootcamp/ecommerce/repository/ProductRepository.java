package turkcell.bootcamp.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import turkcell.bootcamp.ecommerce.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select (count(p) > 0) from Product p where p.id = ?1")
    boolean checkIfProductExists(int id);


}
