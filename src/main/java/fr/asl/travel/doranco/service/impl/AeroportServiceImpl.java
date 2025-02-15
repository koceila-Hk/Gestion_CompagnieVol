package fr.asl.travel.doranco.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import fr.asl.travel.doranco.business.Aeroport;
import fr.asl.travel.doranco.dao.AeroportDao;
import fr.asl.travel.doranco.dao.impl.AeroportDaoImpl;
import fr.asl.travel.doranco.service.AeroportService;

public class AeroportServiceImpl implements AeroportService {

	private AeroportDao aeroportDao = new AeroportDaoImpl();

	@Override
	public Aeroport ajouterAeroport(String nom) {
		Aeroport aeroport = new Aeroport(nom);

		try {
			aeroportDao.createAeroport(aeroport);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aeroport; 
	}

	@Override
	public Aeroport recupererAeroportParId(long id) {
		try {
			return aeroportDao.findOneById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Aeroport> recupererTousLesAeroports() {
		
		try {
			return aeroportDao.findAllAeroports();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public Aeroport modifierAeroport(Aeroport aeroport) {
		try {
			return aeroportDao.updateAeroport(aeroport);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aeroport;
	}

}
