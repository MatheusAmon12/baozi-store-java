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

import com.baozi.store.apirest.model.Client;
import com.baozi.store.apirest.repository.ClientRepository;

@Controller
@RequestMapping("/client")
public class ClientController {
	private ClientRepository repository;
	
	public ClientController(ClientRepository clientRepository) {
		this.repository = clientRepository;
	}
	
	@GetMapping("/")
	public List<Client> getAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/")
	public Client create(@RequestBody Client client) {
		return repository.save(client);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Client client) {
		return repository.findById(id)
				.map(record -> {
					record.setName(client.getName());
					record.setCustomerSince(client.getCustomerSince());
					
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
