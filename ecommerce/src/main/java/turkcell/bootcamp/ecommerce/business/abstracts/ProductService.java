package turkcell.bootcamp.ecommerce.business.abstracts;

import turkcell.bootcamp.ecommerce.business.dto.requests.product.CreateProductRequest;
import turkcell.bootcamp.ecommerce.business.dto.requests.product.UpdateProductRequest;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.CreateProductResponse;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.GetAllProductsResponse;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.GetProductResponse;
import turkcell.bootcamp.ecommerce.business.dto.responses.product.UpdateProductResponse;
import turkcell.bootcamp.ecommerce.entities.Product;

import java.util.List;

public interface ProductService {

    // CRUD
    List<GetAllProductsResponse> findAllProducts();
    GetProductResponse findProductById(int id);
    CreateProductResponse addProduct(CreateProductRequest request);
    UpdateProductResponse updateProduct(int id, UpdateProductRequest request);
    void deleteProductById(int id);



}
