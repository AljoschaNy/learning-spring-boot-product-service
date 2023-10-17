package com.example.learningspringbootproductservice.product.service;

import com.example.learningspringbootproductservice.product.model.Product;
import com.example.learningspringbootproductservice.product.model.ProductVisible;
import com.example.learningspringbootproductservice.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    private final ProductRepository mockProductRepo = mock(ProductRepository.class);
    IdService idService = new IdService();
    ProductService productService = new ProductService(mockProductRepo,idService);

    @Test
    void findAllProducts() {
        List<Product> expected = List.of(
                Product.builder().name("test").price(23.23).build(),
                Product.builder().name("test").price(23.23).build()
        );
        when(mockProductRepo.findAll()).thenReturn(expected);
        List<Product> actual = productService.findAllProducts();
        assertEquals(expected,actual);
    }

    @Test
    void findProductById() {
        Product expected = Product.builder().name("test").price(23.23).build();
        when(mockProductRepo.findById(expected.id())).thenReturn(Optional.of(expected));
        Product actual = productService.findProductById(expected.id());
        assertEquals(expected,actual);
    }

    @Test
    void addProduct() {
        Product expected = Product.builder().id("12").name("test").price(23.23).build();
        when(mockProductRepo.save(any(Product.class))).thenReturn(expected);
        Product actual = productService.addProduct(ProductVisible.builder()
                .name(expected.name())
                .price(expected.price())
                .build());
        assertEquals(expected,actual);
    }

    @Test
    void updateProduct() {
        Product productToUpdate = Product.builder().id("12").name("test").price(23.23).build();
        Product expected = Product.builder().id("12").name("test").price(23.23).build();

        when(mockProductRepo.findById(productToUpdate.id())).thenReturn(Optional.of(productToUpdate));
        when(mockProductRepo.save(any(Product.class))).thenReturn(expected);
        Product actual = productService.updateProduct(expected.id(), expected.price());
        verify(mockProductRepo).findById(productToUpdate.id());
        verify(mockProductRepo).save(expected);
        assertEquals(expected,actual);
    }
}