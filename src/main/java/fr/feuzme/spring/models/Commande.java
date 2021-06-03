package fr.feuzme.spring.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Commande {
	@Id
	private Integer id;
	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;
	@ManyToMany
	@JoinTable(
			name = "commande_has_produit",
			joinColumns = @JoinColumn(name="commande_id"),
			inverseJoinColumns = @JoinColumn(name = "produit_id")
			)
	private Collection<Produit> produits;
}
