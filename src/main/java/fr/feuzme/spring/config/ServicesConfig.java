package fr.feuzme.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.feuzme.spring.models.Categorie;
import fr.feuzme.spring.models.Client;
import fr.feuzme.spring.models.Commande;
import fr.feuzme.spring.models.Produit;
import fr.feuzme.spring.services.GenericService;
import fr.feuzme.spring.services.servicesImpl.CategorieServiceImpl;
import fr.feuzme.spring.services.servicesImpl.ClientServiceImpl;
import fr.feuzme.spring.services.servicesImpl.CommandeServiceImpl;
import fr.feuzme.spring.services.servicesImpl.ProduitServiceImpl;

@Configuration
public class ServicesConfig {
	@Bean
	public GenericService<Categorie> categorieServiceFactory(){
		return new CategorieServiceImpl();
	}
	@Bean
	public GenericService<Client> clientServiceFactory(){
		return new ClientServiceImpl();
	}
	@Bean
	public GenericService<Commande> commandeServiceFactory(){
		return new CommandeServiceImpl();
	}
	@Bean
	public GenericService<Produit> produitServiceFactory(){
		return new ProduitServiceImpl();
	}
}
