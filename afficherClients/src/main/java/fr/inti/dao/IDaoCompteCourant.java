package fr.inti.dao;

import java.util.List;

import fr.inti.entities.CompteCourant;

public interface IDaoCompteCourant {
	CompteCourant getCompteByIdCompte(int idCompte);
	CompteCourant getCompteByIdClient(int idClient);
	void update(CompteCourant compte);
	List<CompteCourant> selectAll();
}
