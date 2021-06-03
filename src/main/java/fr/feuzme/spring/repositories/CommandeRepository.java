package fr.feuzme.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.feuzme.spring.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
	
}
