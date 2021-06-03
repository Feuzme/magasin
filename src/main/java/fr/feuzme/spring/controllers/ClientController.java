package fr.feuzme.spring.controllers;

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

import fr.feuzme.spring.models.Client;
import fr.feuzme.spring.services.GenericService;

@RestController
@RequestMapping("clients")
public class ClientController {
	@Autowired
	private GenericService<Client> service;
	
	@GetMapping()
	public List<Client> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Client findById(@PathVariable Integer id) {
		return this.service.findById(id);
	}
	
	@PostMapping()
	public Client save(Client client) {
		return this.service.save(client);
	}
	
	@PutMapping()
	public Client update(@RequestBody Client client) {
		return this.service.update(client);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody Client client) {
		this.service.delete(client);
	}
}
