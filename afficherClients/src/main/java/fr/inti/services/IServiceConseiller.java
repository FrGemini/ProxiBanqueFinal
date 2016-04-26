package fr.inti.services;

import java.util.List;

import fr.inti.entities.Conseiller;

public interface IServiceConseiller {

	List<Conseiller> listeConseillers();
	void ajouterConseiller(Conseiller conseiller);
	Conseiller getConseillerById(int id);
	void modifierConseiller(Conseiller conseiller); 
}
