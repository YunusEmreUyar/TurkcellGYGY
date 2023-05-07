package turkcell.bootcamp.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import turkcell.bootcamp.ecommerce.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
