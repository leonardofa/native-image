package br.com.leonardo.estudos.springbootgraalvm.products.api;

import br.com.leonardo.estudos.springbootgraalvm.products.dao.ProductsRepository;
import br.com.leonardo.estudos.springbootgraalvm.products.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
  private final ProductsRepository repository;

  @GetMapping("/{id}")
  public Product getProduct(@PathVariable("productId") long id) {
    return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
  }

  @GetMapping
  public Iterable<Product> getAllProducts() {
    return repository.findAll();
  }

}