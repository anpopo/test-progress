package com.example.testprogress.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseRepository extends JpaRepository<Product, Long> {

}
