package fr.feuzme.spring.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.feuzme.spring.models.Produit;
import fr.feuzme.spring.repositories.ProduitRepository;
import fr.feuzme.spring.services.GenericService;

public class ProduitServiceImpl implements GenericService<Produit> {
	@Autowired
	private ProduitRepository repository;

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Produit findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id).get();
	}

	@Override
	public Produit save(Produit entity) {
		// TODO Auto-generated method stub
		return this.repository.save(entity);
	}

	@Override
	public Produit update(Produit entity) {
		Produit produit = this.repository.findById(entity.getId()).get();

		entity.setCategorie(entity.getCategorie() == null ? produit.getCategorie() : entity.getCategorie());
		entity.setNom(entity.getNom() == null ? produit.getNom() : entity.getNom());
		entity.setPrix(entity.getPrix() == null ? produit.getPrix() : entity.getPrix());

		return this.repository.save(entity);
	}

	@Override
	public void delete(Produit entity) {
		this.repository.delete(entity);
	}
}
