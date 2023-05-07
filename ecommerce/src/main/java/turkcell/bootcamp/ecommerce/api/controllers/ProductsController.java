package turkcell.bootcamp.ecommerce.api.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import turkcell.bootcamp.ecommerce.business.abstracts.ProductService;
import turkcell.bootcamp.ecommerce.business.dto.requests.product.CreateProductRequest;
import turkcell.bootcamp.ecommerce.business.dto.requests.product.UpdateProductRequest;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.CreateProductResponse;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.GetAllProductsResponse;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.GetProductResponse;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.UpdateProductResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductsController {

    private final ProductService service;


    @GetMapping
    public List<GetAllProductsResponse> getAllProducts() {
        return service.findAllProducts();
    }

    @GetMapping("/{id}")
    public GetProductResponse getOneProductById(final @PathVariable int id) {
        return service.findProductById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteProductById(final @PathVariable int id) {
        service.deleteProductById(id);
        return "Product deleted successfully.";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse createProduct(final @RequestBody CreateProductRequest request) {
        return service.addProduct(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse updateProduct(final @PathVariable int id, final @RequestBody UpdateProductRequest request) {
        return service.updateProduct(id, request);
    }


}
