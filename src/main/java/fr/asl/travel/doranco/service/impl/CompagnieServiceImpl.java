package fr.asl.travel.doranco.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import fr.asl.travel.doranco.business.Compagnie;
import fr.asl.travel.doranco.dao.CompagnieDao;
import fr.asl.travel.doranco.dao.impl.CompagnieDaoImpl;
import fr.asl.travel.doranco.service.CompagnieService;

public class CompagnieServiceImpl implements CompagnieService {
	private CompagnieDao compagnieDao = new CompagnieDaoImpl();

	@Override
	public Compagnie ajouterCompagnie(String nom) {
		Compagnie compagnie = new Compagnie(nom);
		
		try {
			return compagnieDao.createCompagnie(compagnie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Compagnie recupererCompagnieParId(long id) {
		try {
			return compagnieDao.findOneCompagnieById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Compagnie> recupererToutesCompagnies() {
		try {
			return compagnieDao.findAllCompagnies();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public boolean supprimerCompagnie(long id) {
		try {
			return compagnieDao.deleteCompagnie(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
