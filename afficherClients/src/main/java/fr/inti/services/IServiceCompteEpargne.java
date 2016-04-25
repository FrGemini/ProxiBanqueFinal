package fr.inti.services;

import java.util.List;

import fr.inti.entities.CompteEpargne;

public interface IServiceCompteEpargne {
	List<CompteEpargne> selectAll();
	CompteEpargne selectByIdClient(int idClient);
	void takeMoney(CompteEpargne ce , float montant);
	void addMoney(CompteEpargne ce , float montant);
}
