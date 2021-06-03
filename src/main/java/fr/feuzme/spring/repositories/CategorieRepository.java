package fr.feuzme.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.feuzme.spring.models.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
	
}
