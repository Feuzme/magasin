package fr.feuzme.spring.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.feuzme.spring.models.Client;
import fr.feuzme.spring.repositories.ClientRepository;
import fr.feuzme.spring.services.GenericService;

public class ClientServiceImpl implements GenericService<Client> {
	@Autowired
	private ClientRepository repository;

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Client findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id).get();
	}

	@Override
	public Client save(Client entity) {
		// TODO Auto-generated method stub
		return this.repository.save(entity);
	}

	@Override
	public Client update(Client entity) {
		Client client = this.repository.findById(entity.getId()).get();
		
		entity.setNom(entity.getNom() == null ? client.getNom() : entity.getNom());
		entity.setPrenom(entity.getPrenom()==null ? client.getPrenom() : entity.getPrenom());
		
		return this.repository.save(entity);
	}

	@Override
	public void delete(Client entity) {
		this.repository.delete(entity);
	}
}
