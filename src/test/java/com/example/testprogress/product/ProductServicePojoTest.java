package com.example.testprogress.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServicePojoTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        MemoryRepository memoryRepository = new MemoryRepository();
        ProductPort productPort = new ProductAdapter(memoryRepository);
        this.productService = new ProductService(productPort);
    }


    @Test
    void 상품등록() {
        final AddProductRequest request = 상품등록요청_생성();
        productService.addProduct(request);
    }

    private AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }

}
