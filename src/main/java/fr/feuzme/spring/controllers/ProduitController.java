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

import fr.feuzme.spring.models.Produit;
import fr.feuzme.spring.services.GenericService;

@RestController
@RequestMapping("produits")
public class ProduitController {
	@Autowired
	private GenericService<Produit> service;
	
	@GetMapping()
	public List<Produit> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Produit findById(@PathVariable Integer id) {
		return this.service.findById(id);
	}
	
	@PostMapping()
	public Produit save(Produit produit) {
		return this.service.save(produit);
	}
	
	@PutMapping()
	public Produit update(@RequestBody Produit produit) {
		return this.service.update(produit);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody Produit produit) {
		this.service.delete(produit);
	}
}
