package fr.asl.travel.doranco.dao;

import java.sql.SQLException;
import java.util.List;

import fr.asl.travel.doranco.business.Aeroport;

public interface AeroportDao {
//C
	Aeroport createAeroport(Aeroport aeroport) throws SQLException;
//R
	Aeroport findOneById(long id) throws SQLException;
	List<Aeroport> findAllAeroports() throws SQLException;
//U
	Aeroport updateAeroport(Aeroport aeroport) throws SQLException;
//D
	
}
