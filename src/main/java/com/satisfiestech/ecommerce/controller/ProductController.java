package com.satisfiestech.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;
import com.satisfiestech.ecommerce.model.Product;
import com.satisfiestech.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class ProductController {
  @Autowired private ProductRepository productRepo;
  
  public ProductController(ProductRepository repo) {
      this.productRepo = repo;
  }

  @GetMapping
  public List<Product> getAll() {
    return productRepo.findAll();
  }
  
  @PostMapping
  public Product addProduct(@RequestBody Product product) {
      return productRepo.save(product);
  }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepo.findById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
