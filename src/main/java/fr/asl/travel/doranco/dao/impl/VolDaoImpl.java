package fr.asl.travel.doranco.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.asl.travel.doranco.business.Vol;
import fr.asl.travel.doranco.dao.AeroportDao;
import fr.asl.travel.doranco.dao.CompagnieDao;
import fr.asl.travel.doranco.dao.ConnexionBdd;
import fr.asl.travel.doranco.dao.Requete;
import fr.asl.travel.doranco.dao.VolDao;

public class VolDaoImpl implements VolDao {

	private Connection connection;
	private AeroportDao aeroportDao = new AeroportDaoImpl();
	private CompagnieDao compagnieDao = new CompagnieDaoImpl();

	public VolDaoImpl() {
		try {
			connection = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Vol createFlight(Vol vol) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.AJOUT_VOL, Statement.RETURN_GENERATED_KEYS);
		ps.setTimestamp(1, Timestamp.valueOf(vol.getDateHeureDepart()));
		ps.setTimestamp(2, Timestamp.valueOf(vol.getDateHeureArrivee()));
		ps.setFloat(3, vol.getPrixEnEuro());
		ps.setLong(4, vol.getCompagnie().getId());
		ps.setLong(5, vol.getAeroportDepart().getId());
		ps.setLong(6, vol.getAeroportArrivee().getId());

		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			vol.setId(rs.getLong(1));
		}
		return vol;
	}

	@Override
	public Vol findFlightById(long id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.VOL_PAR_ID);
		ps.setLong(1, id);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Vol vol = new Vol();
			vol.setId(rs.getLong("id"));
			vol.setDateHeureDepart(rs.getTimestamp("heureDepart").toLocalDateTime());
			vol.setDateHeureArrivee(rs.getTimestamp("heureArrivee").toLocalDateTime());
			vol.setPrixEnEuro(rs.getFloat("prixEnEuros"));
			vol.setCompagnie(compagnieDao.findOneCompagnieById(rs.getLong("compagnie_id")));
			vol.setAeroportDepart(aeroportDao.findOneById(rs.getLong("aeroport_depart_id")));
			vol.setAeroportArrivee(aeroportDao.findOneById(rs.getLong("aeroport_arrivee_id")));
			return vol;
		}
		return null;
	}

	@Override
	public List<Vol> findAllFlightsOrderByPrice() throws SQLException {
		List<Vol> vols = new ArrayList<>();
		PreparedStatement ps = connection.prepareStatement(Requete.TOUS_LES_VOLS);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Vol vol = new Vol();
			vol.setId(rs.getLong("id"));
			vol.setDateHeureArrivee(rs.getTimestamp("dateHeureArrivee").toLocalDateTime());
			vol.setDateHeureDepart(rs.getTimestamp("dateHeureDepart").toLocalDateTime());
			vol.setPrixEnEuro(rs.getFloat("prixEnEuro"));
			vol.setCompagnie(compagnieDao.findOneCompagnieById(rs.getLong("compagnie_id")));
			vol.setAeroportDepart(aeroportDao.findOneById(rs.getLong("aeroportDepart_id")));
			vol.setAeroportArrivee(aeroportDao.findOneById(rs.getLong("aeroportArrivee_id")));
			vols.add(vol);
		}
		return vols;
	}
}