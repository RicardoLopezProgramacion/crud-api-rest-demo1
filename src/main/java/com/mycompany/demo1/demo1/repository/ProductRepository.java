package com.mycompany.demo1.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mycompany.demo1.demo1.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
