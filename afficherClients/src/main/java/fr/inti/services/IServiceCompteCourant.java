package fr.inti.services;

import java.util.List;

import fr.inti.entities.CompteCourant;

public interface IServiceCompteCourant {
	List<CompteCourant> selectAll();
	CompteCourant selectByIdClient(int idClient);
	void takeMoney(CompteCourant cc , float montant);
	void addMoney(CompteCourant cc , float montant);
}
