package com.baozi.store.apirest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baozi.store.apirest.model.Order;
import com.baozi.store.apirest.repository.OrderRepository;

@RestController
@RequestMapping({"/order"})
public class OrderController {
	OrderRepository repository;
	
	OrderController(OrderRepository orderRepository) {
		this.repository = orderRepository;
	}
	
	@GetMapping
	public List<Order> getAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Order create(@RequestBody Order order) {
		return repository.save(order);
	}
	
	@PutMapping(path = {"/{id}"})
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Order order) {
		return repository.findById(id)
				.map(record -> {
					record.setClientId(order.getClientId());
					record.setProductId(order.getProductId());
					record.setQuantity(order.getQuantity());
					
					return ResponseEntity.ok().body(record);
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
