package turkcell.bootcamp.ecommerce.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import turkcell.bootcamp.ecommerce.core.exceptions.ProductNotFoundException;
import turkcell.bootcamp.ecommerce.entities.Product;
import turkcell.bootcamp.ecommerce.repository.ProductRepository;

@Component
@AllArgsConstructor
public class ProductBusinessRules {

    private final ProductRepository repository;

    public void checkIfProductExists(final int id) {
        if(!repository.checkIfProductExists(id)) {
            throw new ProductNotFoundException("The product that you are looking for is not found.");
        }
    }


    public void validateProduct(final Product product) {
        if(product.getQuantity() < 0) throw new RuntimeException("Quantity can't less than 0");
        if(product.getPrice() < 0) throw new RuntimeException("Price can't less than 0");
        if(product.getDescription().length() < 10 || product.getDescription().length() > 50) throw new RuntimeException("Descr logic");
    }

}
