package fr.feuzme.spring.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.feuzme.spring.models.Commande;
import fr.feuzme.spring.repositories.CommandeRepository;
import fr.feuzme.spring.services.GenericService;

public class CommandeServiceImpl implements GenericService<Commande> {
	@Autowired
	private CommandeRepository repository;

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Commande findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id).get();
	}

	@Override
	public Commande save(Commande entity) {
		// TODO Auto-generated method stub
		return this.repository.save(entity);
	}

	@Override
	public Commande update(Commande entity) {
		Commande commande = this.repository.findById(entity.getId()).get();
		
		entity.setClient(entity.getClient() == null ? commande.getClient() : entity.getClient());
		entity.setProduits(entity.getProduits() == null ? commande.getProduits() : entity.getProduits());
		
		return this.repository.save(entity);
	}

	@Override
	public void delete(Commande entity) {
		this.repository.delete(entity);
	}
}
