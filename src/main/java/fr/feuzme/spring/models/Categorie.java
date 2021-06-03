package fr.feuzme.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Categorie {
	@Id
	private Integer id;
	@Column(name = "nom")
	private String nom;
}
