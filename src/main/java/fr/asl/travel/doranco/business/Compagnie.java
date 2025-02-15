package fr.asl.travel.doranco.business;

import java.util.ArrayList;
import java.util.List;

public class Compagnie {

	private long id;
	private String nom;
	private List<Vol> vols;

	// constructeur par défaut
	public Compagnie() {
		vols = new ArrayList<>();
	}

	// surcharge du constructeur
	public Compagnie(String nom) {
		this();
		this.nom = nom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	@Override
	public String toString() {
		return "Compagnie [id=" + id + ", nom=" + nom + ", vols=" + vols + "]";
	}

}
