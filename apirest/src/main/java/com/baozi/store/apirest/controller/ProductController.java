package com.baozi.store.apirest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baozi.store.apirest.repository.ProductRepository;
import com.baozi.store.apirest.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	private ProductRepository repository;
	
	public void Product(ProductRepository productRepository) {
		this.repository = productRepository;
	}
	
	@GetMapping("/")
	public List<Product> getAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/")
	public Product create(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Product product) {
		return repository.findById(id)
				.map(record -> {
					record.setName(product.getName());
					record.setPrice(product.getPrice());
					record.setStock(product.getStock());
					
					return ResponseEntity.ok().body(record);
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
