package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Product;
import repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
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
}
