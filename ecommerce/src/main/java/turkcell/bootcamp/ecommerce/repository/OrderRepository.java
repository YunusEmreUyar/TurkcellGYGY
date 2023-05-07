package turkcell.bootcamp.ecommerce.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import turkcell.bootcamp.ecommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
