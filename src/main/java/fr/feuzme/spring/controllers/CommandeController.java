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

import fr.feuzme.spring.models.Commande;
import fr.feuzme.spring.services.GenericService;

@RestController
@RequestMapping("commandes")
public class CommandeController {
	@Autowired
	private GenericService<Commande> service;
	
	@GetMapping()
	public List<Commande> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Commande findById(@PathVariable Integer id) {
		return this.service.findById(id);
	}
	
	@PostMapping()
	public Commande save(Commande commande) {
		return this.service.save(commande);
	}
	
	@PutMapping()
	public Commande update(@RequestBody Commande commande) {
		return this.service.update(commande);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody Commande commande) {
		this.service.delete(commande);
	}
}
