package fr.asl.travel.doranco.service;

import java.time.LocalDateTime;
import java.util.List;

import fr.asl.travel.doranco.business.Vol;

public interface VolService {

	Vol ajouterVol(LocalDateTime dateHeureArrivee, LocalDateTime dateHeureDepart, float prixEnEuro,
			long idAeroportArrivee, long idAeroportDepart, long idCompagnie);

	Vol recupererVolParId(long id);

	List<Vol> recupererVolsTrieParPrix();

}
