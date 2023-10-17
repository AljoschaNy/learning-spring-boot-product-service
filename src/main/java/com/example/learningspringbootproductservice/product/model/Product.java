package com.example.learningspringbootproductservice.product.model;

import lombok.Builder;

@Builder
public record Product(
        String id,
        String name,
        double price
) {
    public Product productWithPrice(double price) {
        return Product.builder()
                .id(this.id)
                .name(this.name)
                .price(price)
                .build();
    }
}
