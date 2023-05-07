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
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "country_id")
    private int id;

    @Column(name = "country_name")
    private String name;

    @OneToMany(mappedBy = "country")
    List<Customer> customers;

    @OneToMany(mappedBy = "country")
    List<Employee> employees;

    @OneToMany(mappedBy = "country")
    List<Supplier> suppliers;


}
