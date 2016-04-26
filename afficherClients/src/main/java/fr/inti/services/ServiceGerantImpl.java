package fr.inti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.inti.dao.IDaoGerant;
import fr.inti.entities.Gerant;

public class ServiceGerantImpl implements IServiceGerant {
	
	@Autowired
	private IDaoGerant daoGerant;

	public List<Gerant> getAllGerants() {
		return daoGerant.getAllGerants();
	}

	public void addGerant(Gerant gerant) {
		daoGerant.addGerant(gerant);
	}
	
	public Gerant getGerantById(int id) {
		return daoGerant.getGerantById(id);
	}

	public void deleteGerant(Gerant gerant) {
		daoGerant.deleteGerant(gerant);
	}

	public void updateGerant(Gerant gerant) {
		daoGerant.updateGerant(gerant);
	}

}
