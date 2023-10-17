package com.example.learningspringbootproductservice.product.repository;

import com.example.learningspringbootproductservice.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
