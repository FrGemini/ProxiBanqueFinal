package fr.inti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.inti.dao.IDaoConseiller;
import fr.inti.entities.Conseiller;

@Service
public class ServiceConseillerImpl implements IServiceConseiller{

	@Autowired
	private IDaoConseiller daoConseiller;

	public List<Conseiller> listeConseillers() {
		return daoConseiller.getAllConseillers();
	}

	public void ajouterConseiller(Conseiller conseiller) {
		daoConseiller.addConseiller(conseiller);
		
	}

	public Conseiller getConseillerById(int id) {
		return daoConseiller.getConseillerById(id);
	}
	
	
}
