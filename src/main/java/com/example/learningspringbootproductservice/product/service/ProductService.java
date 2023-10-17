package com.example.learningspringbootproductservice.product.service;

import com.example.learningspringbootproductservice.product.repository.ProductRepository;
import com.example.learningspringbootproductservice.product.model.Product;
import com.example.learningspringbootproductservice.product.model.ProductVisible;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final IdService idService;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(String id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product addProduct(ProductVisible product) {
        return productRepository.save(
                Product.builder()
                .id(idService.randomId())
                .name(product.name())
                .price(product.price())
                .build()
        );
    }

    public Product updateProduct(String id, double price) {
        Product legacyProduct = findProductById(id);
        Product newProduct = legacyProduct.productWithPrice(price);
        deleteProduct(id);
        productRepository.save(newProduct);
        return newProduct;
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
