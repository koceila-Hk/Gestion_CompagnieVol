package fr.asl.travel.doranco.service.impl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import fr.asl.travel.doranco.business.Vol;
import fr.asl.travel.doranco.dao.VolDao;
import fr.asl.travel.doranco.dao.impl.VolDaoImpl;
import fr.asl.travel.doranco.service.AeroportService;
import fr.asl.travel.doranco.service.CompagnieService;
import fr.asl.travel.doranco.service.VolService;

public class VolServiceImpl implements VolService {

	private VolDao volDao = new VolDaoImpl();

	private AeroportService aeroportService = new AeroportServiceImpl();
	private CompagnieService compagnieService = new CompagnieServiceImpl();

	@Override
	public Vol ajouterVol(LocalDateTime dateHeureArrivee, LocalDateTime dateHeureDepart, float prixEnEuro,
			long idAeroportArrivee, long idAeroportDepart, long idCompagnie) {
		Vol vol = new Vol();
		vol.setDateHeureArrivee(dateHeureArrivee);
		vol.setDateHeureDepart(dateHeureDepart);
		vol.setPrixEnEuro(prixEnEuro);
		vol.setAeroportArrivee(aeroportService.recupererAeroportParId(idAeroportArrivee));
		vol.setAeroportDepart(aeroportService.recupererAeroportParId(idAeroportDepart));
		vol.setCompagnie(compagnieService.recupererCompagnieParId(idCompagnie));

		try {
			volDao.createFlight(vol);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vol;
	}

	@Override
	public Vol recupererVolParId(long id) {

		try {
			return volDao.findFlightById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Vol> recupererVolsTrieParPrix() {

		try {
			return volDao.findAllFlightsOrderByPrice();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
