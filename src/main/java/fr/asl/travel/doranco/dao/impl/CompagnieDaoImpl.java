package fr.asl.travel.doranco.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.asl.travel.doranco.business.Compagnie;
import fr.asl.travel.doranco.dao.CompagnieDao;
import fr.asl.travel.doranco.dao.ConnexionBdd;
import fr.asl.travel.doranco.dao.Requete;

public class CompagnieDaoImpl implements CompagnieDao {

	private Connection connection;

	public CompagnieDaoImpl() {
		try {
			connection = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Compagnie createCompagnie(Compagnie compagnie) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.AJOUT_COMPAGNIE, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, compagnie.getNom());

		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			compagnie.setId(rs.getLong(1));
		}
			return compagnie;
	}

	@Override
	public Compagnie findOneCompagnieById(long id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.COMPAGNIE_PAR_ID);
		ps.setLong(1, id);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Compagnie compagnie = new Compagnie();
			compagnie.setId(rs.getLong("id"));
			compagnie.setNom(rs.getString("nom"));
			return compagnie;
		}
		return null;
	}

	@Override
	public List<Compagnie> findAllCompagnies() throws SQLException {
		List<Compagnie> compagnies = new ArrayList<>();
		PreparedStatement ps = connection.prepareStatement(Requete.TOUTES_LES_COMPAGNIES);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Compagnie compagnie = new Compagnie();
			compagnie.setId(rs.getLong("id"));
			compagnie.setNom(rs.getString("nom"));
			compagnies.add(compagnie);
		}
		return compagnies;
	}

	@Override
	public boolean deleteCompagnie(long id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.SUPPRESSION_COMPAGNIE);
		ps.setLong(1, id);

		return ps.execute();
	}
}
