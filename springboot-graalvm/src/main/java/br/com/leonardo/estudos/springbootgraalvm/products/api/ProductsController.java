package br.com.leonardo.estudos.springbootgraalvm.products.api;

import br.com.leonardo.estudos.springbootgraalvm.products.dao.ProductsRepository;
import br.com.leonardo.estudos.springbootgraalvm.products.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {
  private final ProductsRepository repository;

  @PostMapping
  public Product create(@RequestBody Product product) {
    log.info("Creating product {}", product);
    return repository.save(product);
  }

  @GetMapping("{id}")
  public Product retrive(@PathVariable UUID id) {
    log.info("Retrieving product {}", id);
    return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
  }

  @GetMapping
  public Iterable<Product> retriveAll() {
    log.info("Retrieving all products");
    return repository.findAll();
  }

}