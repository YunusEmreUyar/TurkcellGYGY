package turkcell.bootcamp.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import turkcell.bootcamp.ecommerce.business.abstracts.ProductService;
import turkcell.bootcamp.ecommerce.business.dto.requests.product.CreateProductRequest;
import turkcell.bootcamp.ecommerce.business.dto.requests.product.UpdateProductRequest;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.CreateProductResponse;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.GetAllProductsResponse;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.GetProductResponse;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.UpdateProductResponse;
import turkcell.bootcamp.ecommerce.business.rules.ProductBusinessRules;
import turkcell.bootcamp.ecommerce.core.exceptions.ProductNotFoundException;
import turkcell.bootcamp.ecommerce.entities.Product;
import turkcell.bootcamp.ecommerce.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository repository;

    private final ModelMapper mapper;

    private final ProductBusinessRules rules;

    @Override
    public List<GetAllProductsResponse> findAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream().map(product -> mapper.map(product, GetAllProductsResponse.class)).toList();
    }

    @Override
    public GetProductResponse findProductById(final int id) {
        rules.checkIfProductExists(id);
        Product product = repository.findById(id).orElseThrow();

        return mapper.map(product, GetProductResponse.class);
    }

    @Override
    public CreateProductResponse addProduct(final CreateProductRequest request) {
        Product product = mapper.map(request, Product.class);
        product.setId(0);
        Product savedProduct = repository.save(product);

        return mapper.map(savedProduct, CreateProductResponse.class);
    }

    @Override
    public UpdateProductResponse updateProduct(final int id, final UpdateProductRequest request) {
        rules.checkIfProductExists(id);
        Product product = mapper.map(request, Product.class);
        product.setId(id);
        Product updatedProduct = repository.save(product);

        return mapper.map(updatedProduct, UpdateProductResponse.class);
    }

    @Override
    public void deleteProductById(final int id) {
        rules.checkIfProductExists(id);
        repository.deleteById(id);
    }





}
