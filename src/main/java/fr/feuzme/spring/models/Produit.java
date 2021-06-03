package fr.feuzme.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Produit {
	@Id
	private Integer id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prix")
	private Double prix;
	@OneToOne
	@JoinColumn(name ="categorie_id", referencedColumnName = "id")
	private Categorie categorie;
}
