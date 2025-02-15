package fr.asl.travel.doranco.dao;

import java.sql.SQLException;
import java.util.List;

import fr.asl.travel.doranco.business.Vol;

public interface VolDao {

	Vol createFlight(Vol vol) throws SQLException;

	Vol findFlightById(long id) throws SQLException;

	List<Vol> findAllFlightsOrderByPrice() throws SQLException;

}
