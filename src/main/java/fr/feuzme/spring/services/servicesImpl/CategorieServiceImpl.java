package fr.feuzme.spring.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.feuzme.spring.models.Categorie;
import fr.feuzme.spring.repositories.CategorieRepository;
import fr.feuzme.spring.services.GenericService;

public class CategorieServiceImpl implements GenericService<Categorie> {
	@Autowired
	private CategorieRepository repository;

	@Override
	public List<Categorie> findAll() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Categorie findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id).get();
	}

	@Override
	public Categorie save(Categorie entity) {
		// TODO Auto-generated method stub
		return this.repository.save(entity);
	}

	@Override
	public Categorie update(Categorie entity) {
		Categorie categorie = this.repository.findById(entity.getId()).get();
		
		entity.setNom(entity.getNom() == null ? categorie.getNom() : entity.getNom());
		
		return this.repository.save(entity);
	}

	@Override
	public void delete(Categorie entity) {
		this.repository.delete(entity);
	}
	
}
