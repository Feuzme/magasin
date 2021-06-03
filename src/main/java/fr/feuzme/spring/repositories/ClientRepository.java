package fr.feuzme.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.feuzme.spring.models.Client;


public interface ClientRepository extends JpaRepository<Client, Integer>{

}
