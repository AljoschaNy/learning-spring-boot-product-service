package com.example.learningspringbootproductservice.product.controller;

import com.example.learningspringbootproductservice.product.model.Product;
import com.example.learningspringbootproductservice.product.model.ProductVisible;
import com.example.learningspringbootproductservice.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable String id) {
        return productService.findProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductVisible product) {
        return productService.addProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestParam String id, double price) {
        return productService.updateProduct(id,price);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }


}
