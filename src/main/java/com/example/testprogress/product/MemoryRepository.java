package com.example.testprogress.product;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
class MemoryRepository {

    private final Map<Long, Product> persistence = new HashMap<>();
    private Long sequence = 0L;

    public Product save(Product product) {
        product.assignId(++sequence);
        persistence.put(product.getId(), product);
        return persistence.get(product.getId());
    }
}
