package com.example.learningspringbootproductservice.product;

import lombok.Builder;

@Builder
public record Product(
        String id,
        String name,
        double price
) {
}
