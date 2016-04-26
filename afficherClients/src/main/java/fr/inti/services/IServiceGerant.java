package fr.inti.services;

import java.util.List;

import fr.inti.entities.Gerant;

public interface IServiceGerant {
	
	List<Gerant> getAllGerants();
	void addGerant(Gerant gerant);
	Gerant getGerantById(int id);
	void deleteGerant(Gerant gerant);
	void updateGerant(Gerant gerant);

}
