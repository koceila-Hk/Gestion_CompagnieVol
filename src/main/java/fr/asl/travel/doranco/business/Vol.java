package fr.asl.travel.doranco.business;

import java.time.LocalDateTime;

public class Vol {

	private long id;
	private LocalDateTime ateHeureArrivee;
	private LocalDateTime dateHeureDepart;
	private float prixEnEuro;

	private Aeroport aeroportArrivee;
	private Aeroport aeroportDepart;

	private Compagnie compagnie;

	public Vol() {
		// que doit faire l'application sans intervention des utilisateurs ?
	}

	// quels sont les paramètres attenduent auprès de l'utilisateur pour que l'objet
	// soit créé ?
	public Vol(LocalDateTime dateHeureArrivee, LocalDateTime dateHeureDepart, float prixEnEuro,
			Aeroport aeroportArrivee, Aeroport aeroportDepart, Compagnie compagnie) {
		this();
		this.ateHeureArrivee = dateHeureArrivee;
		this.dateHeureDepart = dateHeureDepart;
		this.prixEnEuro = prixEnEuro;
		this.aeroportArrivee = aeroportArrivee;
		this.aeroportDepart = aeroportDepart;
		this.compagnie = compagnie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDateHeureArrivee() {
		return ateHeureArrivee;
	}

	public void setDateHeureArrivee(LocalDateTime dateHeureArrivee) {
		this.ateHeureArrivee = dateHeureArrivee;
	}

	public LocalDateTime getDateHeureDepart() {
		return dateHeureDepart;
	}

	public void setDateHeureDepart(LocalDateTime dateHeureDepart) {
		this.dateHeureDepart = dateHeureDepart;
	}

	public float getPrixEnEuro() {
		return prixEnEuro;
	}

	public void setPrixEnEuro(float prixEnEuro) {
		this.prixEnEuro = prixEnEuro;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Compagnie getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	@Override
	public String toString() {
		return "Vol [id=" + id + ", dateHeureArrivee=" + ateHeureArrivee + ", dateHeureDepart=" + dateHeureDepart
				+ ", prixEnEuro=" + prixEnEuro + ", aeroportArrivee=" + aeroportArrivee + ", aeroportDepart="
				+ aeroportDepart + ", compagnie=" + compagnie + "]";
	}

}
