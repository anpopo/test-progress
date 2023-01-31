package com.example.testprogress.product;

import org.springframework.stereotype.Component;

@Component
class ProductAdapter implements ProductPort {

    private final MemoryRepository memoryRepository;

    public ProductAdapter(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @Override
    public void save(Product product) {
        memoryRepository.save(product);
    }
}
