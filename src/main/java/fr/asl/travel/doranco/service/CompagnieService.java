package fr.asl.travel.doranco.service;

import java.util.List;

import fr.asl.travel.doranco.business.Compagnie;

public interface CompagnieService {

	Compagnie ajouterCompagnie(String nom);

	Compagnie recupererCompagnieParId(long id);

	List<Compagnie> recupererToutesCompagnies();

	boolean supprimerCompagnie(long id);

}
