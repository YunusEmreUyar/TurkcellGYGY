package turkcell.bootcamp.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import turkcell.bootcamp.ecommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
