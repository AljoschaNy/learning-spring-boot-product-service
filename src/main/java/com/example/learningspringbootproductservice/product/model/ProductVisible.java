package com.example.learningspringbootproductservice.product.model;

import lombok.Builder;

@Builder
public record ProductVisible(
        String name,
        double price
) {
}
