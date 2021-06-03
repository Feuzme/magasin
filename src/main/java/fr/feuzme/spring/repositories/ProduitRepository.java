package fr.feuzme.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.feuzme.spring.models.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}
