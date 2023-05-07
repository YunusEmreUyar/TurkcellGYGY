package turkcell.bootcamp.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "cities")
public class City {
    @Id
    @Column(name = "city_id")
    private int id;

    @Column(name = "city_name")
    private String name;

    @OneToMany(mappedBy = "city")
    List<Customer> customers;

    @OneToMany(mappedBy = "city")
    List<Employee> employees;

    @OneToMany(mappedBy = "city")
    List<Supplier> suppliers;



}
