package com.mycompany.demo1.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.demo1.demo1.entity.Product;
import com.mycompany.demo1.demo1.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("\"Product not found in the id %d", id)));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        var putProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Product not found in the id %d", id)));
        putProduct.setName(product.getName());
        putProduct.setPrice(product.getPrice());
        return productRepository.save(putProduct);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable Integer id){
        var deleteProduct = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException(String.format("Product not found in the id %d, null", id)));
        productRepository.delete(deleteProduct);
        return deleteProduct;
    }

}
