package fr.asl.travel.doranco.business;

public class Aeroport {

	// Attributs
	private long id;
	private String nom;

	public Aeroport() {
	}

	// surcharge de constructeur
	public Aeroport(String nom) {
		this();
		this.nom = nom;
	}

	// Getter Setter
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

	// toString()
	@Override
	public String toString() {
		return "Aeroport [id = " + id + ", nom = " + nom + "]";
	}

}
