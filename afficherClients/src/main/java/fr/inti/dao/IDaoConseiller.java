package fr.inti.dao;

import java.util.List;

import fr.inti.entities.Conseiller;

public interface IDaoConseiller {

	
	List<Conseiller> getAllConseillers();
	Conseiller getConseillerById(int id);
	void addConseiller(Conseiller conseiller); 
}
