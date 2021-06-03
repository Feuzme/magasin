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

import fr.feuzme.spring.models.Categorie;
import fr.feuzme.spring.services.GenericService;

@RestController
@RequestMapping("categories")
public class CategorieController {
	@Autowired
	private GenericService<Categorie> service;
	
	@GetMapping()
	public List<Categorie> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Categorie findById(@PathVariable Integer id) {
		return this.service.findById(id);
	}
	
	@PostMapping()
	public Categorie save(Categorie categorie) {
		return this.service.save(categorie);
	}
	
	@PutMapping()
	public Categorie update(@RequestBody Categorie categorie) {
		return this.service.update(categorie);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody Categorie categorie) {
		this.service.delete(categorie);
	}
}
